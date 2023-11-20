import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, a, b, k, w, h, result;
    static boolean[][] visited;
    static int[] tmp;
    static char[][] map;
    static Queue<Pos> q;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new char[h][w];
        visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
        }

        q = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'W') continue;
                visited = new boolean[h][w];
                bfs(i, j);
            }
        }
        System.out.println(result);

    }

    static void bfs(int x, int y) {
        q.offer(new Pos(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            result = Math.max(result, cur.depth);

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= h || ny >= w || visited[nx][ny] || map[nx][ny] == 'W') {
                    continue;
                }
                visited[nx][ny] = true;
                q.offer(new Pos(nx, ny, cur.depth + 1));
            }

        }

    }

    private static class Pos {
        int x;
        int y;
        int depth;

        public Pos(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}