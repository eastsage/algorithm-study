import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 현재 위치의 동작 수 -> min( 상하좌우 중 최솟값, 나이트 움직임으로 올 수 있는 곳 중 최솟 값 )
 */
public class Main {
    static final int INF = 1_000_000_000; // 무한대
    static int K, W, H; //점프 수, 너비, 높이
    static int[][] map;
    static int[][][] dp;
    static int[] dx = {-1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1}; // 12 종류 0~3 인접 4~11 점프
    static int[] dy = {0, 0, -1, 1, -2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        dp = new int[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                for (int k = 0; k <= K; k++) {
                    dp[i][j][k] = INF;

                }
            }
        }
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for (int i = 0; i < H; i++) {
//            for (int j = 0; j < W; j++) {
//
//                if (i == 0 && j == 0) continue;
//                if (map[i][j] == 1) continue;
//                for (int k = 0; k <= K; k++) {
//                    for (int l = 0; l < 12; l++) {
//                        int nx = i + dx[l];
//                        int ny = j + dy[l];
//                        if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
//                        if (l < 4) {
//                            dp[i][j][k] = Math.min(dp[i][j][k], dp[nx][ny][k] + 1);
//                        } else if (k > 0) {
//                            dp[i][j][k - 1] = Math.min(dp[i][j][k - 1], dp[nx][ny][k] + 1);
//                        }
//                    }
//                }
//            }
//        }
        // only DP 는 안됨
        dp[0][0][K] = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, K});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int k = poll[2];
            int tmp = dp[x][y][k] + 1;
            for (int l = 0; l < 12; l++) {
                int nx = x + dx[l];
                int ny = y + dy[l];
                if (nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == 1) continue;

                if (l < 4) {
                    if (dp[nx][ny][k] > tmp) {
                        dp[nx][ny][k] = tmp;
                        q.offer(new int[]{nx, ny, k});
                    }
                } else if (k > 0) {
                    if (dp[nx][ny][k - 1] > tmp) {
                        dp[nx][ny][k - 1] = tmp;
                        q.offer(new int[]{nx, ny, k - 1});
                    }
                }
            }
        }

        int result = INF;
        for (int i = 0; i <= K; i++) {
            result = Math.min(result, dp[H - 1][W - 1][i]);
        }
        if (result == INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}