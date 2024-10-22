import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] selected, arr;
    static int[][] map, dp;
    static boolean[] visited;
    static Set<List<Integer>> set = new LinkedHashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        selected = new int[m];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        recur(0);
        for (List<Integer> list : set) {
            for (Integer i : list) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void recur(int depth) {
        if (depth == m) {
            Integer[] array = Arrays.stream(selected).boxed().toArray(Integer[]::new);
            set.add(Arrays.asList(array));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            selected[depth] = arr[i];
            recur(depth + 1);
            visited[i] = false;
        }
    }
}