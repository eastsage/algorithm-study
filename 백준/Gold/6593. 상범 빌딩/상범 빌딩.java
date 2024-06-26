import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int z, x, y, cnt;
    static int[] s, e;
    static int[][] arr;
    static char[][][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            z = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if (z == 0 && x == 0 && y == 0) break;

            map = new char[z][x][y];
            visited = new boolean[z][x][y];

            for (int i = 0; i < z; i++) {
                for (int j = 0; j < x; j++) {
                    String input = br.readLine();
                    for (int k = 0; k < y; k++) {
                        map[i][j][k] = input.charAt(k);
                        if (map[i][j][k] == 'S') s = new int[]{i, j, k, 0};
                        if (map[i][j][k] == 'E') e = new int[]{i, j, k, 0};
                    }
                }
                br.readLine();
            }
            cnt = bfs();
            if (cnt == -1) sb.append("Trapped!\n");
            else sb.append("Escaped in " + cnt + " minute(s).\n");
        }
        System.out.println(sb);
    }

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(s);
        visited[s[0]][s[1]][s[2]] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 6; i++) {
                int nz = cur[0] + dz[i];
                int nx = cur[1] + dx[i];
                int ny = cur[2] + dy[i];
                if (nz == e[0] && nx == e[1] && ny == e[2]) return cur[3] + 1;

                if (nx < 0 || ny < 0 || nz < 0 || nx >= x || ny >= y || nz >= z) continue;
                if (map[nz][nx][ny] == '#' || visited[nz][nx][ny]) continue;
                visited[nz][nx][ny] = true;
                q.offer(new int[]{nz, nx, ny, cur[3] + 1});
            }
        }
        return -1;
    }
}