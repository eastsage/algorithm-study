import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int[] dist, arr, target;
    static int[][] dp;
    static boolean[] visited;
    static int n, m, q;
    static int res;
    static List<Integer>[] edges;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        m = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[from].add(to);
            edges[to].add(from);
        }

        q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[from].add(to);
            edges[to].add(from);
            bfs(1);
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static void bfs(int start) {
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist[start] = 0;  // 수도(1번 도시)의 거리는 0

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : edges[cur]) {
                if (dist[next] == -1) {  // 아직 방문하지 않은 도시
                    dist[next] = dist[cur] + 1;
                    queue.offer(next);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            sb.append(dist[i] + " ");
        }
    }
}