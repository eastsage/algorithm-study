import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, r, q;
    static int[] arr, parent, dist;
    static List<int[]>[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
            System.exit(0);
        }
        graph = new List[n + 1];
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[parent].add(new int[]{child, weight});
            graph[child].add(new int[]{parent, weight});
        }
        dfs(1, 0);
        int v = 0;
        int len = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > len) {
                v = i;
                len = dist[i];
            }
        }
        Arrays.fill(dist, 0);
        dfs(v, 0);
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dist[i]);
        }
        System.out.println(result);
    }

    static void dfs(int cur, int prev) {
        for (int[] nxt : graph[cur]) {
            if (nxt[0] == prev) continue;
            dist[nxt[0]] = dist[cur] + nxt[1];
            dfs(nxt[0], cur);
        }
    }
}