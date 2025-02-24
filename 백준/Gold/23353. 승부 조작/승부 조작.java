import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    // 3차원 메모이제이션 배열: memo[i][j][d]는 (i,j)에서 d방향(8방향 중 하나)으로 연속된 흑돌의 길이
    static int[][][] dp;
    // 8방향: {dx, dy}
    // d = 0: 오른쪽 (0,1), 1: 왼쪽 (0,-1), 2: 아래 (1,0), 3: 위 (-1,0),
    // 4: 오른쪽아래 (1,1), 5: 왼쪽위 (-1,-1), 6: 왼쪽아래 (1,-1), 7: 오른쪽위 (-1,1)
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        init();
        dp = new int[n][n][8];
        // memo 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // 기존 흑돌 체인 중 최댓값을 구함.
        int currentMax = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    for (int d = 0; d < 8; d++) {
                        currentMax = Math.max(currentMax, rec(i, j, d));
                    }
                }
            }
        }
        int ans = currentMax;

        // 백돌 하나를 흑돌로 바꿨을 때 최대 연속 흑돌 길이를 구함.
        // (각 방향 쌍: 가로, 세로, 주대각선, 부대각선에 대해)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 2) { // 후보 백돌
                    int bestForThis = 0;

                    // 가로: 오른쪽(0)와 왼쪽(1)
                    int horizontal = 1;
                    horizontal += (inBounds(i, j + dir[0][1]) && map[i][j + dir[0][1]] == 1 ? rec(i, j + dir[0][1], 0) : 0);
                    horizontal += (inBounds(i, j + dir[1][1]) && map[i][j + dir[1][1]] == 1 ? rec(i, j + dir[1][1], 1) : 0);
                    bestForThis = Math.max(bestForThis, horizontal);

                    // 세로: 아래(2)와 위(3)
                    int vertical = 1;
                    vertical += (inBounds(i + dir[2][0], j) && map[i + dir[2][0]][j] == 1 ? rec(i + dir[2][0], j, 2) : 0);
                    vertical += (inBounds(i + dir[3][0], j) && map[i + dir[3][0]][j] == 1 ? rec(i + dir[3][0], j, 3) : 0);
                    bestForThis = Math.max(bestForThis, vertical);

                    // 주대각선: 오른쪽아래(4)와 왼쪽위(5)
                    int diag = 1;
                    diag += (inBounds(i + dir[4][0], j + dir[4][1]) && map[i + dir[4][0]][j + dir[4][1]] == 1 ? rec(i + dir[4][0], j + dir[4][1], 4) : 0);
                    diag += (inBounds(i + dir[5][0], j + dir[5][1]) && map[i + dir[5][0]][j + dir[5][1]] == 1 ? rec(i + dir[5][0], j + dir[5][1], 5) : 0);
                    bestForThis = Math.max(bestForThis, diag);

                    // 부대각선: 왼쪽아래(6)와 오른쪽위(7)
                    int antiDiag = 1;
                    antiDiag += (inBounds(i + dir[6][0], j + dir[6][1]) && map[i + dir[6][0]][j + dir[6][1]] == 1 ? rec(i + dir[6][0], j + dir[6][1], 6) : 0);
                    antiDiag += (inBounds(i + dir[7][0], j + dir[7][1]) && map[i + dir[7][0]][j + dir[7][1]] == 1 ? rec(i + dir[7][0], j + dir[7][1], 7) : 0);
                    bestForThis = Math.max(bestForThis, antiDiag);

                    ans = Math.max(ans, bestForThis);
                }
            }
        }
        System.out.println(ans);
    }

    // 범위 체크
    static boolean inBounds(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }

    // (i,j)에서 d 방향으로 연속된 흑돌(1)의 수를 구하는 재귀 함수 (탑다운 DP)
    static int rec(int i, int j, int d) {
        if (!inBounds(i, j)) return 0;
        if (map[i][j] != 1) return 0;
        if (dp[i][j][d] != -1) return dp[i][j][d];
        int ni = i + dir[d][0];
        int nj = j + dir[d][1];
        dp[i][j][d] = 1 + rec(ni, nj, d);
        return dp[i][j][d];
    }

    // 입력 초기화
    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}