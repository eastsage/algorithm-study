import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[][][] dp; // r, c, pipeEnd(0 가로, 1 세로, 2 대각선)
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 2; i <= N; i++) { // 첫째 줄 값 넣어주기
            if (map[1][i] == 1) break;
            dp[1][i][0] = 1;
        }
        /**
         * 현재 칸의 가로 파이프 수 = 왼쪽 칸의 가로 파이프 + 대각선 파이프
         * 현재 칸의 세로 파이프 수 = 위쪽 칸의 세로 파이프 + 대각선 파이프
         * 현재 칸의 대각선 파이프 수 = 왼쪽 위 칸의 가로 파이프 + 세로 파이프 + 대각선 파이프
         */
        for (int i = 2; i <= N; i++) {
            for (int j = 3; j <= N; j++) {
                if (map[i][j] == 1) continue;
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                if (map[i - 1][j] == 1 || map[i][j - 1] == 1) continue;
                dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
            }
        }
        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += dp[N][N][i];
        }
        System.out.println(result);
    }
}