import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int n, m, x, result;
    static boolean[] visited;
    static int[] parent;
    static List<int[]> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new int[]{v1, v2, cost});
        }
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        Collections.sort(edges, Comparator.comparingInt(a -> a[2]));

        result = 0;
        for (int[] edge : edges) {
            if (find(edge[0])!=find(edge[1])) {
                result += edge[2];
                union(edge[0], edge[1]);
            }
        }
        System.out.println(result);

    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[b] = a;
    }


}