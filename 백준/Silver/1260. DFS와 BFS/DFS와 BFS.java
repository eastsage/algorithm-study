import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, v, cnt;
    static int[][] arr;
    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        map = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            map[v1].add(v2);
            map[v2].add(v1);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(map[i]);
        }
        dfs(0, v);
        Arrays.fill(visited, false);
        sb.append("\n");
        bfs();
        System.out.println(sb);

    }

    static void dfs(int depth, int cur) {
        if (cur == v) visited[cur] = true;
        sb.append(cur).append(" ");
        for (Integer nxt : map[cur]) {
            if (visited[nxt]) continue;
            visited[nxt] = true;
            dfs(depth + 1, nxt);
        }
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");
            for (Integer nxt : map[cur]) {
                if (visited[nxt]) continue;
                visited[nxt] = true;
                q.offer(nxt);
            }
        }

    }
}