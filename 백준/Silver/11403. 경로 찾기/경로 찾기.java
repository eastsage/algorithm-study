import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] input;
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N][N];
        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            bfs(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int[] ints : visited) {
            for (int i : ints) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        int[] visit = new int[N];
//        Arrays.fill(visit, 0);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer temp = q.poll();
                for (int j = 0; j < N; j++) {
                    if (input[temp][j] == 1 && visit[j] == 0) {
                        visit[j] = 1;
                        q.offer(j);
                    }
                }
            }
        }
        visited[start] = visit;
    }
}