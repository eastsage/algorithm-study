import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int n, k, result;
    static int[] m;
    static boolean[] visited;
    static int[] dx = {-1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[210_000];

        if (n == k) {
            System.out.println(0);
            return;
        }

        bfs();
        System.out.println(result);
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);
        visited[n] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            result++;

            for (int i = 0; i < size; i++) {
                Integer cur = q.poll();

                for (int j = 0; j < 3; j++) {
                    int nx = cur + dx[j];
                    if (nx == cur) {
                        nx = cur * 2;
                    }

                    if (nx < 0 || nx > 100_000) continue;
                    if (visited[nx]) continue;
                    if (nx == k) return;
                    q.offer(nx);
                    visited[nx] = true;
                }
            }
        }

    }
}