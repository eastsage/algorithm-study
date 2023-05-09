import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n, m, a, b, result;
    static Set<Integer>[] pToc, cTop;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        pToc = new Set[n + 1]; // index == 부모 & value == 자식
        cTop = new Set[n + 1]; // index == 부모 & value == 자식
        visited = new boolean[n + 1];
        result = -1;
        for (int i = 0; i < n + 1; i++) {
            pToc[i] = new HashSet();
            cTop[i] = new HashSet();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            pToc[parent].add(child);
            cTop[child].add(parent);
        }

        visited[a] = true;
        dfs(0, a);

        System.out.println(result);
    }

    static void dfs(int cnt, int node) {
        if (node == b) {
            result = cnt;
            return;
        }
        for (Integer child : pToc[node]) {
            if (!visited[child]) {
                visited[child] = true;
                dfs(cnt + 1, child);
            }
        }
        for (Integer parent : cTop[node]) {
            if (!visited[parent]) {
                visited[parent] = true;
                dfs(cnt + 1, parent);
            }
        }


    }

}