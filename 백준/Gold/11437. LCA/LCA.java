import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, m;
    static int[] arr, parent, lev;
    static List<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        lev = new int[n + 1];
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1, 0, 1);

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lca(a, b);
        }
        System.out.println(sb);
    }

    static void lca(int a, int b) {
        if (lev[a] > lev[b]) {
            lca(parent[a], b);
        } else if (lev[a] < lev[b]) {
            lca(a, parent[b]);
        } else {
            if (a == b) {
                sb.append(a).append("\n");
                return;
            }
            lca(parent[a], parent[b]);
        }
    }

    static void dfs(int cur, int prev, int level) {
        lev[cur] = level;
        for (Integer nxt : graph[cur]) {
            if (nxt == prev) continue;
            parent[nxt] = cur;
            dfs(nxt, cur, level + 1);
        }
    }
}