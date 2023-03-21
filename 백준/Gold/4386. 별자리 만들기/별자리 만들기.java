import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Node[] nodes;
    static List<Edge>[] edges;
    static boolean[] visited;
    static double result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        nodes = new Node[n];
        edges = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                edges[i].add(new Edge(j, getDist(nodes[i], nodes[j])));
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(i+" : {");
//            for (Edge edge : edges[i]) {
//                System.out.println("edge.to = " + edge.to);
//                System.out.println("edge.cost = " + edge.cost);
//            }
//            System.out.println("}");
//        }

        PriorityQueue<Edge> pq = new PriorityQueue();
        pq.offer(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.to]) continue;

            visited[cur.to] = true;
            result += cur.cost;

            for (Edge edge : edges[cur.to]) {
                if (visited[edge.to]) continue;
                pq.offer(edge);
            }
        }
        System.out.println(result);
    }

    static double getDist(Node n1, Node n2) {
        return Math.sqrt((Math.pow(Math.abs(n1.x - n2.x), 2)) + (Math.pow(Math.abs(n1.y - n2.y), 2)));
    }

    static class Edge implements Comparable<Edge> {
        int to;
        double cost;

        public Edge(int to, double cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }
    }

    static class Node {
        double x;
        double y;

        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}