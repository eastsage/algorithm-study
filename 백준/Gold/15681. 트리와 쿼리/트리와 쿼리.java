import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, r, q;
    static int[] arr, parent, size;
    static List<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        size = new int[n + 1];
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


        Arrays.fill(size, 1);
        dfs(r, 0);
        for (int i = 0; i < q; i++) {
            int query = Integer.parseInt(br.readLine());
            System.out.println(size[query]);
        }
    }

    static void dfs(int cur, int prev) {
        for (Integer nxt : graph[cur]) {
            if (nxt == prev) continue;
            dfs(nxt, cur);
            size[cur] += size[nxt];
        }
    }
}