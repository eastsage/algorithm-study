import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[][] cost;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cost = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        result = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(1, i, i, 0);
            visited[i] = false;
        }
        System.out.println(result);
    }

    static void dfs(int depth, int start, int pos, int costSum) {
        if (depth == N && cost[pos][start] != 0) {
            result = Math.min(result, costSum + cost[pos][start]);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && cost[pos][i] != 0) {
                visited[i] = true;
                dfs(depth + 1, start, i, costSum + cost[pos][i]);
                visited[i] = false;
            }
        }
    }
}