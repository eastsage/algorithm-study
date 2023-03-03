import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int M, N , H;
    static Deque<Pos> q;
    static int[][][] box;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        q = new ArrayDeque<>();
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    box[k][i][j] = Integer.parseInt(st.nextToken());
                    if (box[k][i][j] == 1) {
                        q.add(new Pos(i, j, k, 0));
                    }
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int max = 0;
        while (!q.isEmpty()) {
            Pos tmp = q.poll();
            int x = tmp.x;
            int y = tmp.y;
            int z = tmp.z;
            max = Math.max(max, tmp.cnt);
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || nz < 0 || nz >= H) {
                    continue;
                }
                if (box[nz][nx][ny] == 0) {
                    q.add(new Pos(nx, ny, nz, tmp.cnt + 1));
                    box[nz][nx][ny] = 1;
                }
            }
        }
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (box[k][i][j] == 0) {
                        return -1;
                    }
                }
            }
        }
        return max;
    }

    static class Pos{
        int x;
        int y;
        int z;
        int cnt;

        public Pos(int x, int y, int z, int cnt) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }
    }
}