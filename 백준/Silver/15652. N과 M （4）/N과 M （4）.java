import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int n, m, cnt;
    static int[] dp, arr, selected;
    static int[][] stats;
    static List<int[]> aList = new ArrayList<>();
    static boolean[] visited;
    static int[] dx = {0, 1, -1, 0, 1, 1, -1, -1};
    static int[] dy = {1, 0, 0, -1, 1, -1, 1, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        selected = new int[m];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        recur(0, 1);
        System.out.println(sb);

    }
    static void recur(int depth, int prev) {
        if (depth == m) {
            for (int i : selected) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = prev; i <= n; i++) {
            selected[depth] = i;
            recur(depth + 1, i);
        }
    }
}