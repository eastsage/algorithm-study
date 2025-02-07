import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static long[] dist;
    static boolean[] visible;
    static List<long[]>[] edges;
    // INF는 10만 * 10만보다 큰 값 (여기서는 안전하게 Long.MAX_VALUE/2 사용)
    static final long INF = Long.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        init();
        dijkstra();
        if (dist[n - 1] == INF) System.out.println(-1);
        else System.out.println(dist[n - 1]);
    }

    static void dijkstra() {
        // 우선순위 큐에 {노드번호, 현재까지 비용}을 담는데, 비용은 long형으로 비교합니다.
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int curNode = (int) cur[0];
            long curCost = cur[1];
            if (curNode == n - 1) return;
            if (dist[curNode] < curCost) continue;
            if (visible[curNode]) continue;
            for (long[] nxt : edges[curNode]) {
                int nextNode = (int) nxt[0];
                long nextCost = nxt[1];
                if (dist[nextNode] > dist[curNode] + nextCost) {
                    dist[nextNode] = dist[curNode] + nextCost;
                    pq.offer(new long[]{nextNode, dist[nextNode]});
                }
            }
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // visible 배열: 입력에서 읽은 값이 0이 아니면 true로 설정
        visible = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (val != 0) visible[i] = true;
        }

        // 간선 정보를 저장할 리스트 배열 (노드별 인접 리스트)
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        // dist 배열 초기화 (도달 불가능하면 INF)
        dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        // 간선 정보 입력 (양방향 그래프로 가정)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            edges[from].add(new long[]{to, cost});
            edges[to].add(new long[]{from, cost});
        }
    }
}