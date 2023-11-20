import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int m, n, k;
    static long result;
    static boolean[] visited;
    static Set<Integer>[] edges;
    static int[] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        edges = new Set[n + 1];
        visited = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n + 1; i++) {
            edges[i] = new HashSet<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == b) continue;
            edges[a].add(b);
            edges[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            result += recur(i);
        }
        if (result > k) {
            System.out.println("Oh no");
        } else {
            System.out.println(result);
        }
    }

    static int recur(int cur) {
        visited[cur] = true;
        int cost = arr[cur];

        for (Integer i : edges[cur]) {
            if (visited[i]) continue;
            cost = Math.min(cost, recur(i));
        }
        return cost;
    }
}