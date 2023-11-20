import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, a, b, k, w, h, result, l;
    static boolean[] visited;
    static int[] human;
    static int[][] map;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        human = new int[n + 1];
        visited = new boolean[n + 1];
        List<Integer>[] friends = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            friends[i] = new ArrayList();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int human1 = Integer.parseInt(st.nextToken());
            int human2 = Integer.parseInt(st.nextToken());
            friends[human1].add(human2);
            friends[human2].add(human1);
        }

        Queue<Integer> q = new ArrayDeque<>();
        visited[1] = true;
        for (Integer i : friends[1]) {
            result++;
            visited[i] = true;
            q.offer(i);
        }
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (Integer i : friends[poll]) {
                if (visited[i]) continue;
                visited[i] = true;
                result++;
            }
        }
        System.out.println(result);
    }
}