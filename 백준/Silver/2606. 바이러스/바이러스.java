import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, m, result;
    static Set<Integer>[] edges;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        edges = new Set[n + 1];
        for (int i = 1; i < n + 1; i++) {
            edges[i] = new HashSet();
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            edges[n1].add(n2);
            edges[n2].add(n1);
        }
        dfs(1);
        System.out.println(result - 1);
    }

    static void dfs(int cur) {
        result++;
        visited[cur] = true;

        for (Integer next : edges[cur]) {
            if (visited[next]) continue;
            dfs(next);
        }
    }
}