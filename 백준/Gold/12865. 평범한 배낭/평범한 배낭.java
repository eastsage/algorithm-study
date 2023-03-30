import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1_000_000_000;
    static int N, K;
    static int[] ws, vs;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ws = new int[N + 1];
        vs = new int[N + 1];
        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            ws[i] = Integer.parseInt(st.nextToken());
            vs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) { // i: 물건
            for (int j = 1; j <= K; j++) { // j: 가방의 무게
                // 해당 물건의 무게가 w를 초과하는지
                if (ws[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], vs[i] + dp[i - 1][j - ws[i]]);
                }

            }
        }
        System.out.println(dp[N][K]);
//        System.out.println(Arrays.deepToString(dp));
    }
}