import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class Main {
    static int n, m, x, result;
    static int[][] cost;
    static int[] parent;
    static List<Integer> known;
    static List<int[]> edges;
    static List<Integer>[] party;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k;
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        int[] true_man = new int[k];
        for (int i = 0; i < k; i++) {
            true_man[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[n + 1];
        party = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int party_size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < party_size; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int first_man = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(first_man, party[i].get(j));
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int leader = party[i].get(0);
            boolean flag = true;
            for (int j = 0; j < k; j++) {
                if (find(leader) == find(true_man[j])) {

                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }


    static int find(int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[b] = a;
    }
}