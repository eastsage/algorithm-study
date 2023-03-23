import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] values;
    static int[][] dp;
    static final int invalid = 1000 * 1000 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        values = new int[N + 1][3];
        dp = new int[N + 1][3];
        int result = invalid;

        for(int i = 1 ; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3; j++){
                values[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0; k < 3; k++) {
            for(int i = 0 ; i < 3; i++) {
                if (i == k) {
                    dp[1][i] = values[1][i];
                } else {
                    dp[1][i] = invalid;
                }
            }

            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + values[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + values[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + values[i][2];
            }

            for (int i = 0; i < 3; i++) {
                if (i != k) {
                    result = Math.min(result, dp[N][i]);
                }
            }
        }
        System.out.println(result);
    }
}