import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    static int N, cnt, result;
    static ArrayList<Person> pList;
    static int[][] sList;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            pList = new ArrayList<Person>(); // 사람 리스트
            sList = new int[2][]; //계단 리스트
            result = Integer.MAX_VALUE;

            StringTokenizer st = null;

            for (int i = 0, k = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    int c = Integer.parseInt(st.nextToken());
                    if (c == 1) {
                        pList.add(new Person(i, j));
                    } else if (c > 1) {
                        sList[k++] = new int[]{i, j, c};
                    }
                }
            }

            cnt = pList.size(); // 총 인원 수
            selected = new int[cnt];
            divide(0);

            System.out.println("#" + tc + " " + result);
        }
    }

    //power set
    private static void divide(int index) {
        if (index == cnt) {
            int res = go();
            result = Math.min(result, res);
            return;
        }

        // 계단 0 선택
        selected[index] = 0;
        divide(index + 1);

        // 계단 1 선택
        selected[index] = 1;
        divide(index + 1);
    }

    // 선택된 계단에 따라 사람들의 리스트 만들고 내려가기 처리 후, 소요된 시간 리턴
    static int go() {
        ArrayList<Person>[] list = new ArrayList[]{new ArrayList<Person>(), new ArrayList<Person>()};
        for (int i = 0; i < cnt; i++) {
            Person p = pList.get(i);
            int no = selected[i];
            p.arrivalTime = Math.abs(p.r - sList[no][0]) + Math.abs(p.c - sList[no][1]); //계단까지의 거리 추가
            list[no].add(p);
        }
        int timeA = 0, timeB = 0;
        if (list[0].size() > 0) {
            timeA = processDown(list[0], sList[0][2]);
        }
        if (list[1].size() > 0) {
            timeB = processDown(list[1], sList[1][2]);
        }

        return Math.max(timeA, timeB);
    }

    static int processDown(ArrayList<Person> list, int height) {
        // refactoring : 자신보다 3칸 앞에 있는 사람이 계단을 내려가고 있는지 체크
        // 사람 계단 이동 완료 시간 = 입구도착시간 + 1 + (추가 대기 시간) + 계단 높이
        // 추가 대기 시간 : 3칸 앞의 사람의 남은 계단 길이


        Collections.sort(list); // 계단 입구까지 도착시간이 빠른 순으로 정렬
        int size = list.size() + 3; // 0,1,2번째 사람도 i - 3 체크하기 위해 3의 크기를 더 줌 -> if문 처리하기 싫어서
        int[] D = new int[size];

        for (int i = 3; i < size; i++) {
            Person p = list.get(i - 3);
            if (D[i - 3] <= p.arrivalTime + 1) {
                D[i] = p.arrivalTime + 1 + height;
            } else { // 3칸 앞에 사람이 아직 내려가는중
                D[i] = D[i - 3] + height;
            }
        }

        return D[size - 1];

    }

    static class Person implements Comparable<Person> {
        int r, c, arrivalTime;

        public Person(int r, int c) {
            this.r = r;
            this.c = c;
        }


        @Override
        public int compareTo(Person o) {
            return Integer.compare(this.arrivalTime, o.arrivalTime);
        }
    }
}