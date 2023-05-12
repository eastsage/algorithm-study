import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, period, holeCnt;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input != 0) {
                    holeCnt++;
                }
                map[i][j] = input;
            }
        } // input end

        boolean isSplit = false;
        while (!isSplit) {
            melt();
            if (holeCnt != 0) {
                int[] startPoint = findStartPoint();
                isSplit = checkSplit(0, startPoint);
            } else {
                System.out.println(0);
                return;
            } 
        }
        System.out.println(period);
    }

    static void melt() {
        int meltedCnt = 0;
        int[][] nMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        continue;
                    }
                    if (map[nx][ny] == 0) {
                        cnt++;
                    }
                }
                int value = map[i][j] - cnt;
                if (value <= 0) {
                    value = 0;
                    meltedCnt++;
                }
                nMap[i][j] = value;
            }
        }

        map = nMap;
        holeCnt -= meltedCnt;
        period++;
    }

    private static int[] findStartPoint() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    static boolean checkSplit(int depth, int[] pos) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(pos);
        visited[pos[0]][pos[1]] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            depth++;

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        if (depth == holeCnt) {
            return false;
        } else {
            return true;
        }
    }

}