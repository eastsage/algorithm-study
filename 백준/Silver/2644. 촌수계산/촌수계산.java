import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.DoubleToIntFunction;

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
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        edges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            edges[n1].add(n2);
            edges[n2].add(n1);
        }

        recur(a, 0);
        if (result == 0) {
            System.out.println(-1);
        }
    }

    private static void recur(int node, int chon) {
        visited[node] = true;

        if (node == b) {
            result++;
            System.out.println(chon);
            return;
        }

        for (Integer nxt : edges[node]) {
            if (visited[nxt]) continue;
            recur(nxt, chon + 1);
        }
    }
}