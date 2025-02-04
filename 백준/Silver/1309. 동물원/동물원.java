import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int[] arr;
    static int[][] map, dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][3];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        System.out.println(recur(0, 0));
    }

    static int recur(int depth, int state) {
        if (depth == n) {
            return 1;
        }
        if (dp[depth][state] != -1) {
            return dp[depth][state];
        }

        int res = 0;
        if (state == 0) {
            // 이전 열이 비어 있을 때:
            // 현재 열에서 사자를 배치하지 않는 경우: 다음 상태 0
            // 현재 열에서 사자를 배치하는 경우: 2가지 선택, 다음 상태 1
            res = recur(depth + 1, 0) + 2 * recur(depth + 1, 1);
        } else {
            // 이전 열에 사자가 있을 때:
            // 현재 열에서 사자를 배치하지 않는 경우: 다음 상태 0
            // 현재 열에서 사자를 배치하는 경우: 1가지 (반대쪽 한 칸), 다음 상태 1
            res = recur(depth + 1, 0) + recur(depth + 1, 1);
        }
        return dp[depth][state] = res % 9901;
    }
}