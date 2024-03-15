import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


class Main {
    static int n, m, k, x;
    static long result;
    static boolean[] visited;
    static int[] map, parent, time;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        time = new int[200000];
        parent = new int[200000];
        visited = new boolean[200000];
        bfs();

        // 순서대로 구하기 위해 stack 에 담았다가 다시 pop
        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        int index = k;

        while (index != n) {
            stack.push(parent[index]);
            index = parent[index];
        }

        // 최종 출력
        sb.append(time[k] - 1 + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        time[n] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == k) return;

            for (int i = 0; i < 3; i++) {
                int nx = cur + dx[i];
                if (nx == cur) nx *= 2;

                if (nx < 0 || nx > 100000) continue;

                if (time[nx] == 0) {
                    q.add(nx);
                    time[nx] = time[cur] + 1;
                    parent[nx] = cur;
                }
            }
        }
    }
}