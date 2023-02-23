import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100_001];
        if (n == k) {
            System.out.println(0);
            return;
        }
        bfs(0);
    }

    static void bfs(int cnt) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(n);

        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                int tmp = q.poll();
                if (tmp + 1 <= 100000 && !visited[tmp + 1]) {
                    if (tmp + 1 == k) {
                        System.out.println(cnt);
                        return;
                    }
                    q.offer(tmp + 1);
                    visited[tmp + 1] = true;
                }
                if (tmp - 1 >= 0 && !visited[tmp - 1]) {
                    if (tmp - 1 == k) {
                        System.out.println(cnt);
                        return;
                    }
                    q.offer(tmp - 1);
                    visited[tmp - 1] = true;
                }
                if (tmp * 2 <= 100000 && !visited[tmp * 2]) {
                    if (tmp * 2 == k) {
                        System.out.println(cnt);
                        return;
                    }
                    q.offer(tmp * 2);
                    visited[tmp * 2] = true;
                }
            }
        }
    }
}