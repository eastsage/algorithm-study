import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, result;
    static int[] t, p, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(recur(0));
//        System.out.println(result);

        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (i + t[i] > n) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], dp[i + t[i]] + p[i]);
            }
        }
        System.out.println(dp[0]);
    }

    static int recur(int day) {
        if (day == n) {
            return 0;
        }
        if (day > n) {
            return -1_123_123_123;
        }
        if (dp[day] != -1) {
            return dp[day];
        }
        dp[day] = Math.max(recur(day + 1), recur(day + t[day]) + p[day]);
        return dp[day];
    }
}