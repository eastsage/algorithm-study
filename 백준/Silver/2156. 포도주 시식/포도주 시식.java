import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[10010][3];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(recur(0, 0));
    }

    static int recur(int cur, int cnt) {
        if (cur == n) return 0;
        if (dp[cur][cnt] != -1) return dp[cur][cnt];

        int res = 0;
        if (cnt >= 2) {
            res = Math.max(res, recur(cur + 1, 0));
        } else {
            res = Math.max(res, recur(cur + 1, 0));
            res = Math.max(res, recur(cur + 1, cnt + 1) + arr[cur]);
        }
        dp[cur][cnt] = res;
        return res;
    }
}