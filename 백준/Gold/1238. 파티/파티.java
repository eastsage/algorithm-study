import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int n, m, x, result;
    static boolean[] visited;
    static int[] dist, rDist;
    static ArrayList<int[]>[] edges, rEdges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        rDist = new int[n + 1];

        edges = new ArrayList[n + 1];
        rEdges = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            edges[i] = new ArrayList<>();
            rEdges[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
            rDist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            edges[s].add(new int[]{e, t});
            rEdges[e].add(new int[]{s, t});
        }
        dijkstra(x);
        dijkstra2(x);
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dist[i] + rDist[i]);
        }
        System.out.println(result);
    }
    static void dijkstra(int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{s, 0});
        dist[s] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (dist[cur[0]] < cur[1]) continue;

            for (int[] ints : edges[cur[0]]) {
                if (dist[ints[0]] > ints[1] + cur[1]) {
                    dist[ints[0]] = ints[1] + cur[1];
                    pq.offer(new int[]{ints[0], dist[ints[0]]});
                }
            }
        }
    }

    static void dijkstra2(int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{s, 0});
        rDist[s] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (rDist[cur[0]] < cur[1]) continue;

            for (int[] ints : rEdges[cur[0]]) {
                if (rDist[ints[0]] > ints[1] + cur[1]) {
                    rDist[ints[0]] = ints[1] + cur[1];
                    pq.offer(new int[]{ints[0], rDist[ints[0]]});
                }
            }
        }
    }
}