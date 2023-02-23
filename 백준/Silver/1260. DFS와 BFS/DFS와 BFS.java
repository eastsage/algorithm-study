import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, start;
    static boolean[][] matrix;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        matrix = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            matrix[p1][p2] = true;
            matrix[p2][p1] = true;
        }
        dfs(start);
        sb.append(System.lineSeparator());
        Arrays.fill(visited, false);
        bfs();
        System.out.println(sb);
    }
    static void dfs(int vertex) {
        sb.append(vertex).append(" ");
        visited[vertex] = true;

        for (int i = 1; i <= N; i++) {
            if (matrix[vertex][i] && !visited[i]) {
                dfs(i);
            }
        }
    }
    static void bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer tmp = q.poll();
                sb.append(tmp).append(" ");
                for (int j = 1; j <= N; j++) {
                    if (matrix[tmp][j] && !visited[j]) {
                        q.offer(j);
                        visited[j] = true;
                    }
                }
            }
        }
    }
}