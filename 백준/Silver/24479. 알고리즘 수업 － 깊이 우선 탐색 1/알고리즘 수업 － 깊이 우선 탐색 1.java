import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int n, m, r;
    static List<Integer>[] edges;
    static boolean[] visited;
    static int[] order;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            edges[v1].add(v2);
            edges[v2].add(v1);
        }


        for (int i = 1; i <= n; i++) {
            Collections.sort(edges[i]);
        }

        visited = new boolean[n + 1]; // -> 이미 방문한 정점인지 아닌지
        order = new int[n + 1]; // -> 촐력 저장용

        dfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(order[i]).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int cur) { // current 현재
        visited[cur] = true;
        order[cur] = cnt++;

        for (int next : edges[cur]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
