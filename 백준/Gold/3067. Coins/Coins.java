import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int[] arr, map;
    static int[][] dp;
    static boolean[][] visited;
    static int n, m, res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            m = Integer.parseInt(br.readLine());

            dp = new int[m + 1][n];
            for (int i = 0; i <= m; i++) {
                Arrays.fill(dp[i], -1);
            }

            System.out.println(recur(0, 0));
        }
    }

    static int recur(int money, int idx) {
        if (money == m) return 1;
        if (money > m) return 0;
        if (dp[money][idx] != -1) return dp[money][idx];

        int tmp = 0;
        for (int i = idx; i < n; i++) {
            tmp += recur(money + arr[i], i);
        }

        return dp[money][idx] = tmp;
    }
}