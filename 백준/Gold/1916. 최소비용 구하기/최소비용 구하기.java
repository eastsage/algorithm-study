import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[] arr, dist;
    static int[][] map, dp, cost;
    static boolean[] visited;
    static List<int[]>[] edges;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        edges = new List[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<int[]>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[s].add(new int[]{e, c});
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        dijkstra(s, e);
        System.out.println(dist[e]);
    }

    static void dijkstra(int s, int e) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{s, 0});
        dist[s] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            if (poll[0] == e) return;

            for (int[] nxt : edges[poll[0]]) {
                if (dist[nxt[0]] > nxt[1] + poll[1]) {
                    dist[nxt[0]] = nxt[1] + poll[1];
                    pq.add(new int[]{nxt[0], dist[nxt[0]]});
                }
            }
        }
    }
}