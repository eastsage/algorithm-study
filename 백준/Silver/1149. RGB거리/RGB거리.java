import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, result;
    static int[][] cost, dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        result = 1_000_000_000;
        cost = new int[n][4];
        dp = new int[n][4];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = recur(0, 3);
        System.out.println(result);
    }

    static int recur(int cur, int prev) {
        if (cur == n) {
            return 0;
        }
        if (dp[cur][prev] != -1) {
            return dp[cur][prev];
        }
        int tmp = (int) 1e9;
        for (int i = 0; i < 3; i++) {
            if (i == prev) {
                continue;
            }
            tmp = Math.min(tmp, recur(cur + 1, i) + cost[cur][i]);
        }
        return dp[cur][prev] = tmp;
    }
}