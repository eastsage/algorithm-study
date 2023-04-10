import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static int[] parents;
    public static int[] children;

    public static ArrayList<Edge> edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        long sum = 0;
        edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sum += c;
            edges.add(new Edge(a, b, c));
        }
        parents = new int[n + 1];
        children = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parents[i] = i;
            children[i] = 1;
        }

        long answer = 0;
        Collections.sort(edges);

        for (Edge edge : edges) {
            answer += sum * union(edge.from, edge.to);
            answer %= 1000000000;
            sum -= edge.cost;
        }

        System.out.println(answer);

    }

    public static int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    public static long union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return 0;
        }
        parents[b] = a;
        long cnt = (long) children[a] * children[b];
        children[a] += children[b];
        children[b] = 0;
        return cnt;

    }

    public static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = Math.min(from, to);
            this.to = Math.max(to, from);
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return o.cost - this.cost;
        }
    }
}