import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, a, b, k, w, h, result, l;
    static boolean[][] visited;
    static int[] goal;
    static int[][] map;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            result = Integer.MAX_VALUE;
            map = new int[l][l];
            visited = new boolean[l][l];
            int[] cur = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            goal = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            bfs(cur);
            sb.append(result).append("\n");
        }
        System.out.println(sb);

    }

    static void bfs(int[] cur) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{cur[0], cur[1], 0});
        visited[cur[0]][cur[1]] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            if (poll[0] == goal[0] && poll[1] == goal[1]) {
                result = Math.min(result, poll[2]);
                continue;
            }

            for (int i = 0; i < 8; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= l || ny >= l || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, poll[2] + 1});
            }
        }
    }
}