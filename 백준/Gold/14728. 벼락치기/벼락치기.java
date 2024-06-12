import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, t;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[n][2];
        dp = new int[101][10010];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //t
            arr[i][1] = Integer.parseInt(st.nextToken()); //s
        }
        System.out.println(recur(0, t));
    }
    static int recur(int cur, int time) {
        if (time < 0) return -1_000_000_000;
        if (cur == n) return 0;
        if (dp[cur][time] != -1) return dp[cur][time];

        int res = 0;
        res = Math.max(res, recur(cur + 1, time - arr[cur][0]) + arr[cur][1]);
        res = Math.max(res, recur(cur + 1, time));
        dp[cur][time] = res;
        return res;
    }
}