import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int n, m, x, result;
    static int[][] cost;
    static int[] parent;
    static List<int[]> edges;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int a = find(v1);
            int b = find(v2);
            parent[b] = a;
        }
        cost = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 2; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                pq.add(new int[]{i, j, cost[i][j]});
            }
        }


        int min = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int a = find(cur[0]);
            int b = find(cur[1]);
            if (a == b) continue;
            parent[b] = a;
            min += cur[2];
            cnt++;
            sb.append(cur[0]).append(" ").append(cur[1]).append("\n");
        }
        sb.insert(0, min + " " + cnt + "\n");
        System.out.println(sb);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[b] = a;
    }


}