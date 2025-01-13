import java.io.*;

public class Main {
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] used;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[8][7];
        visited = new boolean[8][7];
        used = new boolean[7][7];

        for (int i = 0; i < 8; i++) {
            String s = br.readLine();
            for (int j = 0; j < 7; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        recur(0, 0);
        System.out.println(res);
    }

    static void recur(int x, int y) {
        if (x == 8) {
            res++;
            return;
        }

        if (visited[x][y]) {
            if (y == 6) {
                recur(x + 1, 0);
            } else {
                recur(x, y + 1);
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 8 || ny >= 7) continue;
            if (visited[nx][ny]) continue;

            int p1 = map[x][y];
            int p2 = map[nx][ny];

            if (used[p1][p2]) continue;

            use(p1, p2);
            visited[x][y] = true;
            visited[nx][ny] = true;

            if (y == 6) {
                recur(x + 1, 0);
            } else {
                recur(x, y + 1);
            }

            reUse(p1, p2);
            visited[x][y] = false;
            visited[nx][ny] = false;
        }
    }

    static void use(int a, int b) {
        used[a][b] = true;
        used[b][a] = true;
    }

    static void reUse(int a, int b) {
        used[a][b] = false;
        used[b][a] = false;
    }
}