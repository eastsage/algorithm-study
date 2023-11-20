import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int m, n;
    static long result;
    static int[][] dp;
    static int[] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(recur2(s, e, 1)).append("\n");
        }
        System.out.println(sb);
//        for (int i = 1; i < n + 1; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

    }

    static int recur2(int s, int e, int cnt) {
        if (e - s <= 1 && arr[s] == arr[e]) {

            return 1;
        }
        if (dp[s][e] != -1) {
            return dp[s][e];
        }
        if (arr[s] != arr[e]) {
            return 0;
        }
        dp[s][e] =  recur2(s + 1, e - 1, cnt + 1);
        return dp[s][e];
    }

    static void recur(int s, int e) {
        if (s == e) {
            System.out.println(1);
            return;
        }
        if (arr[s] != arr[e]) {
            System.out.println(0);
            return;
        }
        recur(s + 1, e - 1);
    }
}