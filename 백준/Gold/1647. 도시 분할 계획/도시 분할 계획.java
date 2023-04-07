import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result, cnt, max;
    static int[] parents;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        parents = new int[N + 1];
        edges = new Edge[M];
        init();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to, cost);
        }
        Arrays.sort(edges);


        for (Edge edge : edges) {
            if (union(edge.to, edge.from)) {
                result += edge.cost;
                max = Math.max(max, edge.cost);
                if (++cnt == N - 1) {
                    System.out.println(result - max);
                    return;
                }
            }
        }
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a <= b) {
                parents[b] = a;
            } else {
                parents[a] = b;
            }
            return true;
        }
        return false;
    }

    static int find(int a) {
        if (parents[a] == a) {
            return a;
        } else {
            return parents[a] = find(parents[a]);
        }
    }

    static void init() {
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}