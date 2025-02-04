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

    static int recur(int depth, int prev) {
        if (depth == n) {
            return 1;
        }
        if (dp[depth][prev] != -1) {
            return dp[depth][prev];
        }
        int tmp = 0;
        if (prev == 0) {
            tmp += recur(depth + 1, 0);
            tmp += recur(depth + 1, 1);
            tmp += recur(depth + 1, 2);
        } else if (prev == 1) {
            tmp += recur(depth + 1, 0);
            tmp += recur(depth + 1, 2);
        } else {
            tmp += recur(depth + 1, 0);
            tmp += recur(depth + 1, 1);
        }
        return dp[depth][prev] = tmp % 9901;
    }
}