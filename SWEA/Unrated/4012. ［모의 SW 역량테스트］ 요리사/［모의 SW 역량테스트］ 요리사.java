import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] taste;
    static List<Integer> food;
    static Integer[] temp;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            taste = new int[N][N];
            food = new ArrayList<Integer>(N);
            temp = new Integer[N / 2];
            min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                food.add(i);
            }
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    taste[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            combination(0, 0);
            System.out.println("#" + test_case + " " + min);
        }
    }

    private static void combination(int cnt, int start) {
        // 하나의 조합이 완성되면 화면에 출력
        if (cnt == N / 2) {
            List<Integer> p1 = Arrays.asList(temp);
            List<Integer> sub = new ArrayList<>(food);
            sub.removeAll(p1);
            List<Integer> p2 = new ArrayList<>(sub);
            int score1 = getScore(p1);
            int score2 = getScore(p2);
            min = Math.min(min, Math.abs(score1 - score2));
            return;
        }
        for (int i = start; i < N; i++) {
            temp[cnt] = food.get(i);
            combination(cnt + 1, i + 1);
        }
    }

    static int getScore(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) {
                    continue;
                }
                sum += taste[list.get(i)][list.get(j)];
            }
        }
        return sum;
    }
}