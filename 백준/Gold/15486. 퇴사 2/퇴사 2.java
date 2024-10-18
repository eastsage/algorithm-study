import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] t, p, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];
        dp = new int[n + 51];
//        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(recur(0));
        Arrays.fill(dp, -100000000);
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + t[i]] + p[i], dp[i + 1]);
        }
        System.out.println(dp[0]);
    }
    static int recur(int cur) {
        if (cur > n) {
            return -2_000_000_000;
        }
        if (cur == n) {
            return 0;
        }
        if (dp[cur] != -1) {
            return dp[cur];
        }

        return dp[cur] = Math.max(recur(cur + t[cur]) + p[cur], recur(cur + 1));
    }
}