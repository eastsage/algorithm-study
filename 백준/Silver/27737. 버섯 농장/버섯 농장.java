import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] dist, arr, target;
    static int[][] map;
    static int[][] dp;
    static boolean[] visited;
    static int n, m, k;
    static int res;
    static List<Integer>[] edges;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0) continue;
                list.add(bfs(i, j));
            }
        }

        for (Integer i : list) {
            res += i / k;
            if (i % k > 0) res++;
        }

        if (res > m || res == 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println("POSSIBLE");
            System.out.println(m - res);
        }
    }

    static int bfs(int x, int y) {
        ArrayDeque<int[]> pq = new ArrayDeque<>();
        pq.offer(new int[]{x, y});
        map[x][y] = 2;
        int cnt = 1;
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (map[nx][ny] > 0) continue;
                pq.offer(new int[]{nx, ny});
                map[nx][ny] = 2;
                cnt++;
            }
        }
        return cnt;
    }
}