import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n, m, cnt;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tCase = 1; tCase <= T; tCase++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            cnt = 0;
            parents = new int[n];
            makeSet();
            m = Integer.parseInt(st.nextToken());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                union(a, b);
            }
            for (int i = 0; i < n; i++) {
                if (i == parents[i]) {
                    cnt++;
                }
            }
            System.out.println("#" + tCase + " " + cnt);
        }
    }
    static int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }
    static boolean union(int a, int b) {
        int aroot = find(a);
        int broot = find(b);

        if (aroot == broot) {
            return false;
        }
        if (a < b) {
            parents[broot] = aroot;
        } else {
            parents[aroot] = broot;
        }
        return true;
    }
    private static void makeSet() {
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }
}