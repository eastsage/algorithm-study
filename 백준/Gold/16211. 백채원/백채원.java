import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k, m;
    static int[] dist, fansDist;
    static List<Integer> fanList;
    static List<int[]>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        edges = new ArrayList[n + 1];
        fanList = new ArrayList();
        dist = new int[n + 1];
        fansDist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(fansDist, Integer.MAX_VALUE);
        dist[1] = 0;


        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            edges[a].add(new int[] {b, t});
            edges[b].add(new int[] {a, t});
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            fanList.add(Integer.parseInt(st.nextToken()));
        }

        dijkstra();
        dijkstraOfFans();
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (dist[i] < fansDist[i]) result.add(i);
        }
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (Integer i : result) {
            sb.append(i).append(" ");
        }
        if (sb.length() != 0) sb.deleteCharAt(sb.length() - 1);
        else sb.append(0);
        System.out.println(sb.toString());

    }

    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[] {1, 0});

        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int node = tmp[0];
            int cost = tmp[1];

            if (cost > dist[node]) continue;
            for (int[] nxt : edges[node]) {
                if (fanList.contains(nxt[0])) continue; // 못지나감
                int newDist = dist[node] + nxt[1];
                if (dist[nxt[0]] > newDist) {
                    dist[nxt[0]] = newDist;
                    pq.offer(new int[]{nxt[0], newDist});
                }
            }
        }
    }
    static void dijkstraOfFans() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (Integer i : fanList) {
            fansDist[i] = 0;
            pq.offer(new int[]{i, 0});
        }

        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int node = tmp[0];
            int cost = tmp[1];

            if (cost > fansDist[node]) continue;
            for (int[] nxt : edges[node]) {
                if (nxt[0] == 1) continue;
                int newDist = fansDist[node] + nxt[1];
                if (fansDist[nxt[0]] > newDist) {
                    fansDist[nxt[0]] = newDist;
                    pq.offer(new int[]{nxt[0], newDist});
                }
            }
        }
    }
}