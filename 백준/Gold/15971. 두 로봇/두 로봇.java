import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, a, b;
    static boolean[] visited;
    static int[] map, footprint, tmp;
    static List<Edge>[] edges;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        map = new int[n + 1];
        tmp = new int[n + 1];
        visited = new boolean[n + 1];
        edges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[node1].add(new Edge(node2, cost));
            edges[node2].add(new Edge(node1, cost));
        }

        recur(a, 0);
//        System.out.println(Arrays.toString(footprint));
        int[] costs = new int[footprint.length - 1];
        for (int i = 1; i < footprint.length; i++) {
            int from = footprint[i - 1];
            int to = footprint[i];
            for (Edge edge : edges[from]) {
                if (edge.to == to) {
                    costs[i - 1] = edge.cost;
                    break;
                }
            }
        }
        Arrays.sort(costs);
        int sum = 0;
        for (int i = 0; i < costs.length - 1; i++) {
            sum += costs[i];
        }
        System.out.println(sum);

    }

    static void recur(int cur, int depth) {
        tmp[depth] = cur;
        visited[cur] = true;

        if (cur == b) {
            footprint = Arrays.copyOf(tmp, depth + 1);
            return;
        }
        for (Edge edge : edges[cur]) {
            if (visited[edge.to]) continue;
            recur(edge.to, depth + 1);
        }
    }

    private static class Edge {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}