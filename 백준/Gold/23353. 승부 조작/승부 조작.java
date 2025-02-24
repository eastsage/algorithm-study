import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int[][][] memo;
    // x: 세로축, y: 가로축
    static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        init();
        memo = new int[n][n][8];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        // 기존 흑돌 체인 중 최댓값 계산
        int currentMax = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(map[i][j] == 1) {
                    for (int d = 0; d < 8; d++){
                        currentMax = Math.max(currentMax, rec(i, j, d));
                    }
                }
            }
        }
        int ans = currentMax;

        // 백돌 후보 하나를 흑돌로 바꿨을 때, 4방향 쌍(가로, 세로, 주대각선, 부대각선)별 최대 연속 길이 계산
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(map[i][j] == 2) { // 후보 백돌
                    int bestForThis = 0;
                    // 4방향 쌍: 0-1, 2-3, 4-5, 6-7
                    for (int k = 0; k < 4; k++){
                        int d1 = k * 2;      // 첫번째 방향
                        int d2 = k * 2 + 1;  // 반대 방향
                        int chain = 1; // 바꾼 돌 자체 포함

                        int nx = i + dx[d1], ny = j + dy[d1];
                        if(inBounds(nx, ny) && map[nx][ny] == 1) {
                            chain += rec(nx, ny, d1);
                        }

                        nx = i + dx[d2]; ny = j + dy[d2];
                        if(inBounds(nx, ny) && map[nx][ny] == 1) {
                            chain += rec(nx, ny, d2);
                        }

                        bestForThis = Math.max(bestForThis, chain);
                    }
                    ans = Math.max(ans, bestForThis);
                }
            }
        }
        System.out.println(ans);
    }

    // (x, y)에서 d 방향(dx[d], dy[d])으로 연속된 흑돌(1)의 개수를 반환 (탑다운 DP)
    static int rec(int x, int y, int d) {
        if (!inBounds(x, y)) return 0;
        if (map[x][y] != 1) return 0;
        if (memo[x][y][d] != -1) return memo[x][y][d];
        int nx = x + dx[d];
        int ny = y + dy[d];
        memo[x][y][d] = 1 + rec(nx, ny, d);
        return memo[x][y][d];
    }

    // x: 세로, y: 가로에 대한 범위 체크
    static boolean inBounds(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    // 입력 처리
    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}