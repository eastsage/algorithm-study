import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, d;
    static int[] arr, parent;
    static List<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new List[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        dfs(1, 0);
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    static void dfs(int cur, int prev) {
        for (int nxt : graph[cur]) {
            if (nxt == prev) continue;
            parent[nxt] = cur;
            dfs(nxt, cur);
        }
    }
}