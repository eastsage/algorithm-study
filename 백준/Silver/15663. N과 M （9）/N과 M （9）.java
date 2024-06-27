import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] s, e;
    static int[] arr, selected;
    static char[][][] map;
    static boolean[] visited;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        selected = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        dfs(0);
    }

    static void dfs(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++)
                System.out.print(selected[i] + " ");
            System.out.println();
        } else {
            int before = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i])
                    continue;

                if (before != arr[i]) {
                    visited[i] = true;
                    selected[cnt] = arr[i];
                    before = arr[i];
                    dfs(cnt + 1);
                    visited[i] = false;
                }
            }
        }
    }
}