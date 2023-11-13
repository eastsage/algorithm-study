import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int n, m, result, k;
    static int[] map;
    static List[] edges;
    static int[] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] dv = {2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] visited = new int[100001];

        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(n, 1));
        visited[n] = 1;

        while (!q.isEmpty()) {
            Loc now = q.poll();

            if (now.idx + 1 >= 0 && now.idx + 1 <= 100000) { // 앞으로 한칸
                if (visited[now.idx + 1] == 0 || visited[now.idx + 1] > now.cost + 1) {
                    visited[now.idx + 1] = now.cost + 1;
                    q.add(new Loc(now.idx + 1, now.cost + 1));
                }
            }

            if (now.idx - 1 >= 0 && now.idx - 1 <= 100000) { // 뒤로 한칸
                if (visited[now.idx - 1] == 0 || visited[now.idx - 1] > now.cost + 1) {
                    visited[now.idx - 1] = now.cost + 1;
                    q.add(new Loc(now.idx - 1, now.cost + 1));
                }
            }

            if (now.idx * 2 >= 0 && now.idx * 2 <= 100000) { // 순간이동
                if (visited[now.idx * 2] == 0 || visited[now.idx * 2] > now.cost) {
                    visited[now.idx * 2] = now.cost;
                    q.add(new Loc(now.idx * 2, now.cost));
                }
            }

        }

        System.out.println(visited[k] - 1);
    }

    private static class Loc {
        int idx;
        int cost;

        public Loc(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}