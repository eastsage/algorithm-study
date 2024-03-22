import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int n, d;
    static int[] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int longestIncreasingSeq = 0;
        for (int i = 1; i <= n; i++) {
            longestIncreasingSeq = Math.max(longestIncreasingSeq, recur(i));
        }
        System.out.println(n - longestIncreasingSeq);
    }

    static int recur(int cur) {
        if (cur == n) {
            return 1;
        }
        if (dp[cur] != -1) {
            return dp[cur];
        }
        dp[cur] = 1;
        for (int i = cur; i <= n; i++) {
            if (arr[cur] < arr[i]) {
                dp[cur] = Math.max(dp[cur], recur(i) + 1);
            }
        }
        return dp[cur];
    }
}