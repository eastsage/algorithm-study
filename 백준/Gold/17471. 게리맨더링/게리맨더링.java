import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Position[] positions;
    static ArrayList<ArrayList<Integer>> list;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        positions = new Position[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int peopleNum = Integer.parseInt(st.nextToken());
            positions[i] = new Position(i, peopleNum);
        }

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                list.get(i).add(temp);
            }
        }

        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 1; i <= N / 2; i++) {
            comb(1, N, i, A);
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }


    public static void comb(int start, int n, int r, ArrayList<Integer> A) {
        if (r == 0) {
            gerrymandering(A);
            return;
        }

        for (int i = start; i <= n; i++) {
            A.add(i);
            comb(i + 1, n, r - 1, A);
            A.remove(A.size() - 1);
        }
    }
    // 할당받은 지역의 인구수의 차이를 계산하는 함수.

    public static void gerrymandering(ArrayList<Integer> A) {
        // A 지역구가 잘 연결되어있는지 확인
        if (!isConnect(positions[A.get(0)].x, A, A.size())) {
            return;
        }

        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (A.contains(i)) {
                continue;
            }
            B.add(i);
        }

        // B 지역구가 잘 연결되어있는지 확인
        if (!isConnect(positions[B.get(0)].x, B, B.size())) {
            return;
        }

        int resultA = 0;

        // A 지역구 인구 계산
        for (int i = 0; i < A.size(); i++) {
            resultA += positions[A.get(i)].peopleNum;
        }

        int resultB = 0;

        // B 지역구 인구 계산
        for (int i = 0; i < B.size(); i++) {
            resultB += positions[B.get(i)].peopleNum;
        }

        int result = Math.abs(resultA - resultB);
        ans = Math.min(ans, result);

    }
    // 선거구가 모두 연결되어있는지 확인.

    public static boolean isConnect(int num, ArrayList<Integer> arr, int size) {
        boolean[] visited = new boolean[N + 1];
        visited[num] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);

        int count = 1;
        while (!q.isEmpty()) {
            int start = q.poll();

            for (int i : list.get(start)) {
                // 이미 방문한 적이 없고, arr에 속해야 함.
                if (!visited[i] && arr.contains(i)) {
                    visited[i] = true;
                    count++;
                    q.offer(i);
                }
            }
        }

        if (count == size) {
            return true;
        }
        return false;
    }
}

class Position {
    int x;
    int peopleNum;

    Position(int x, int peopleNum) {
        this.x = x;
        this.peopleNum = peopleNum;
    }
}