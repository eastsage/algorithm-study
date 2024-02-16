import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, k, result;
    static int[] w, v;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        w = new int[n];
        v = new int[n];
        dp = new int[n][k + 100];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(recur(0, 0));
    }
    static int recur(int cur, int weight) {
        if (weight > k) {
            return -1123123123;
        }
        if (cur >= n) {
            return 0;
        }
        if (dp[cur][weight] != -1) {
            return dp[cur][weight];
        }


        dp[cur][weight] = Math.max(recur(cur + 1, weight), recur(cur + 1, weight + w[cur]) + v[cur]);
        return dp[cur][weight];
    }
}