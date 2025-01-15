import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int[] arr, target;
    static boolean[][] dp;
    static boolean[] visited;
    static int n, m, res = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new boolean[31][40001];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        target = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        recur(0, 0);

        for (int i : target) {
            if (dp[n][i]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }
        System.out.println(sb);
    }

    static void recur(int cur, int w) {
        if (dp[cur][w]) return;
        dp[cur][w] = true;
        if (cur == n) return;

        recur(cur + 1, w + arr[cur + 1]);
        recur(cur + 1, w);
        recur(cur + 1, Math.abs(w - arr[cur + 1]));
    }
}