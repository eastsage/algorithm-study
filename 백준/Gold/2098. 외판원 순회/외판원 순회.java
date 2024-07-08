import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 2_000_000_000;
    static int n;
    static int[][] cost, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) cost[i][j] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][(1 << n) - 1];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        System.out.println(dfs(0, 1) + "\n");
    }

    static int dfs(int cur, int visit) {
        if (visit == (1 << n) - 1) {
            if (cost[cur][0] == 0) return INF;
            return cost[cur][0];
        }
        if (dp[cur][visit] != -1) return dp[cur][visit];
        dp[cur][visit] = INF;

        for (int i = 0; i < n; i++) {
            if (isVisited(i, visit) && cost[cur][i] != 0) {
                dp[cur][visit] = Math.min(dfs(i, visit | (1 << i)) + cost[cur][i], dp[cur][visit]);
            }
        }
        return dp[cur][visit];
    }

    static boolean isVisited(int i, int visit) {
        return (visit & (1 << i)) == 0;
    }
}