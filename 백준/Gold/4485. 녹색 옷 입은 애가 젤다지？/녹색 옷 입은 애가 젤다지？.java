import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 1_000_000_000;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static boolean visited[][];
    static int map[][];
    static int dist[][];
    static int N, nx, ny;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int count = 1;

        String tmp = "";
        while (!(tmp = br.readLine()).isEmpty()) {
            N = Integer.parseInt(tmp);
            if (N == 0) {
                break;
            }

            map = new int[N][N];
            visited = new boolean[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF;
                }
            }

            BFS(0, 0, map[0][0]);
            sb.append("Problem ").append(count).append(": ").append(dist[N - 1][N - 1]).append("\n");
            count++;
        }

        System.out.print(sb);

    } // End of main

    private static void BFS(int x, int y, int roopy) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited[x][y] = true;
        pq.offer(new Node(x, y, roopy));

        while (!pq.isEmpty()) {

            Node cur = pq.poll();

            for (int i = 0; i < 4; i++) {
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (!visited[nx][ny] && dist[nx][ny] > (map[nx][ny] + cur.cost)) {
                    dist[nx][ny] = map[nx][ny] + cur.cost;
                    visited[nx][ny] = true;
                    pq.offer(new Node(nx, ny, dist[nx][ny]));
                }

            }
        }

    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}