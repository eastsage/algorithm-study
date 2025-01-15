import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int[][] arr, target;
    static int[][] dp;
    static boolean[] visited;
    static int n, m;
    static long res;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n + 1][n + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        System.out.println(recur(1, n));
    }

    static int recur(int a, int b) {
        if (a == b) {
            return 0;
        }
        if (a + 1 == b) {
            return arr[a][0] * arr[a][1] * arr[b][1];
        }
        if (dp[a][b] != Integer.MAX_VALUE) {
            return dp[a][b];
        }

        for (int i = a; i < b; i++) {
            int tmp = 0;
            tmp = recur(a, i) + recur(i + 1, b) + (arr[a][0] * arr[i][1] * arr[b][1]);
            dp[a][b] = Math.min(dp[a][b], tmp);
        }
        return dp[a][b];
    }
}