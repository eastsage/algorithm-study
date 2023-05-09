import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int f, s, g, u, d, result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        visited = new boolean[f + 1];
        result = -1;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{s, 0});
        visited[s] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
//            System.out.print("pos = " + cur[0]);
//            System.out.println(" / cnt = " + cur[1]);
            if (cur[0] == g) {
                System.out.println(cur[1]);
                return;
            }

            int cnt = cur[1];
            int up = cur[0] + u;
            int down = cur[0] - d;

            if (up <= f && !visited[up]) {
                q.offer(new int[]{up, cnt + 1});
                visited[up] = true;
            }

            if (down > 0 && !visited[down]) {
                q.offer(new int[]{down, cnt + 1});
                visited[down] = true;
            }
        }

        System.out.println("use the stairs");
    }
}