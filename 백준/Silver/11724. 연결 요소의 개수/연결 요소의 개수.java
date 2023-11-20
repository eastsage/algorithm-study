import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int m, n, a, b;
    static long result;
    static boolean[] visited;
    static List<Integer>[] edges;
    static int[] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edges = new List[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            recur(i);
            result++;
        }
        System.out.println(result);
    }

    static void recur(int cur) {
        visited[cur] = true;

        for (Integer i : edges[cur]) {
            if (visited[i]) continue;
            recur(i);
        }
    }
}