import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Planet[] planets;
    static List<Edge>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        planets = new Planet[N];
        edges = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            planets[i] = new Planet(i,
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
            edges[i] = new ArrayList<>();
        }

        Arrays.sort(planets, (p1, p2) -> p1.x - p2.x);
        for (int i = 0; i < N - 1; i++) {
            int cost = Math.abs(planets[i].x - planets[i + 1].x);
            edges[planets[i].id].add(new Edge(planets[i + 1].id, cost));
            edges[planets[i + 1].id].add(new Edge(planets[i].id, cost));
        }
        Arrays.sort(planets, (p1, p2) -> p1.y - p2.y);
        for (int i = 0; i < N - 1; i++) {
            int cost = Math.abs(planets[i].y - planets[i + 1].y);
            edges[planets[i].id].add(new Edge(planets[i + 1].id, cost));
            edges[planets[i + 1].id].add(new Edge(planets[i].id, cost));
        }
        Arrays.sort(planets, (p1, p2) -> p1.z - p2.z);
        for (int i = 0; i < N - 1; i++) {
            int cost = Math.abs(planets[i].z - planets[i + 1].z);
            edges[planets[i].id].add(new Edge(planets[i + 1].id, cost));
            edges[planets[i + 1].id].add(new Edge(planets[i].id, cost));
        }
//        for (int i = 0; i < edges.length; i++) {
//            System.out.println();
//            System.out.println("from = " + i);
//            for (Edge edge : edges[i]) {
//                System.out.println("\t to = " + edge.to + "  cost = " + edge.cost);
//            }
//        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        int result = 0;
        pq.offer(new Edge(0, 0));

//        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.to]) {
                continue;
            }
            visited[cur.to] = true;
//            sb.append(cur.to);
            result += cur.cost;

            for (Edge edge : edges[cur.to]) {
                if (!visited[edge.to]) {
                    pq.add(edge);
                }
            }
        }
//        System.out.println(sb);
        System.out.println(result);
    }
}

class Edge implements Comparable<Edge> {
    int to;
    int cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

class Planet {
    int id;
    int x;
    int y;
    int z;

    public Planet(int id, int x, int y, int z) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}