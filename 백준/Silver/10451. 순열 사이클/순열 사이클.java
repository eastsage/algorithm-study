import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] selected, arr;
    static int[][] map, dp;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            List<List<Integer>> cycles = new ArrayList<>();
            findCycle(cycles);
            sb.append(cycles.size()).append("\n");
        }

        System.out.println(sb);

    }
    static void findCycle(List<List<Integer>> cycles) {
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            List<Integer> cycle = new ArrayList<>();

            int x = i;
            while (!visited[x]) {
                visited[x] = true;
                cycle.add(x);
                x = arr[x];
            }
            cycles.add(cycle);
        }
    }


}