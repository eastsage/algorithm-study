import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, a, b, k;
    static boolean[] visited;
    static int[] map, footprint, tmp;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100_001];
        bfs();
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n, 0});
        visited[n] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]] = true;

            if (cur[0] == k) {
                System.out.println(cur[1]);
                return;
            }

            int[] nxt = {cur[0] * 2, cur[0] + 1, cur[0] - 1};
            for (int i = 0; i < 3; i++) {
                if (nxt[i] >= 0 && nxt[i] <= 100_000 && !visited[nxt[i]]) {
                    q.offer(new int[]{nxt[i], cur[1] + 1});
                }
            }
        }
    }
}