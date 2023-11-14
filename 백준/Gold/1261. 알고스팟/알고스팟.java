import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, result;
    static long min, max;
    static int[][] visited;
    static int[][] map;
    static char[] chars;
    static int[] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;

        map = new int[n + 1][m + 1];
        visited = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(visited[i], 9999999);
        }
        for (int i = 1; i <= n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j + 1] = Integer.valueOf(split[j]);
            }
        }
        bfs();
        System.out.println(result);

    }

    static void bfs() {
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(1, 1, 0));

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            if (cur.x == n && cur.y == m) {
                result = Math.min(result, cur.cnt);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
                if (map[nx][ny] > 0) {
                    if (visited[nx][ny] <= cur.cnt + 1) continue;
                    visited[nx][ny] = cur.cnt + 1;
                    q.offer(new Pos(nx, ny, cur.cnt + 1));
                } else {
                    if (visited[nx][ny] <= cur.cnt) continue;
                    visited[nx][ny] = cur.cnt;
                    q.offer(new Pos(nx, ny, cur.cnt));
                }
            }
        }
    }

    private static class Pos {
        int x;
        int y;
        int cnt;

        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}