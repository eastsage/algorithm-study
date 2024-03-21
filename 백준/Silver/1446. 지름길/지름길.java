import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int n, d;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        graph = new List[10001];
        for (int i = 0; i <= 1000; i++) {
            graph[i] = new ArrayList<>();
        }

        dist = new int[10001];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, cost));
        }

        dijkstra(0);

        System.out.println(dist[d]);
    }

    static void dijkstra(int s) {
        if (s > d) return;

        if (dist[s + 1] > dist[s] + 1) {
            dist[s + 1] = dist[s] + 1;
        }
        for (int i = 0; i < graph[s].size(); i++) {
            if (dist[s] + graph[s].get(i).cost < dist[graph[s].get(i).v]) {
                dist[graph[s].get(i).v] = dist[s] + graph[s].get(i).cost;
            }
        }

        dijkstra(s + 1);
    }

    static class Node {
        int v;
        int cost;

        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}