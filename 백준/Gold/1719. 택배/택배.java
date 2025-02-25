import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = 2_000_000_000;
    static int n, m;
    static int[][] map, dist;
    static int[][] dp;
    static List<int[]>[] edges;
    static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 1; i <= n; i++) {
            dijkstra(i);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    sb.append("- ");
                } else if (j == n) {
                    sb.append(map[i][j]);
                } else {
                    sb.append(map[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra(int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{s, 0});
        dist[s][s] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1];
            if (dist[s][curNode] < curCost) continue;

            for (int[] nxt : edges[cur[0]]) {
                int node = nxt[0];
                int cost = nxt[1];


                if (dist[s][node] > curCost + cost) {
                    dist[s][node] = curCost + cost;
                    if (curNode == s) {
                        map[s][node] = node;
                    } else {
                        map[s][node] = map[s][curNode];
                    }
                    pq.offer(new int[]{node, dist[s][node]});
                }
            }
        }
    }

    // 입력 처리
    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        dist = new int[n + 1][n + 1];
        for (int[] ints : dist) {
            Arrays.fill(ints, INF);
        }
        edges = new List[m + 1];
        for (int i = 1; i <= m; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[a].add(new int[]{b, cost});
            edges[b].add(new int[]{a, cost});
        }
    }
}