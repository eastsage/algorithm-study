import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n, m;
    static int[] parents;
    static int[] command = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tCase = 1; tCase <= T; tCase++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            parents = new int[n + 1];
            makeSet();
            m = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tCase).append(" ");

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    command[j] = Integer.parseInt(st.nextToken());
                }
                if (command[0] == 0) {
                    union(command[1], command[2]);
                } else {
                    if (find(command[1]) == find(command[2])) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }

    static boolean union(int a, int b) {
        int aroot = find(a);
        int broot = find(b);

        if (aroot == broot) {
            return false;
        }
        if (a < b) {
            parents[aroot] = broot;
        } else {
            parents[broot] = aroot;
        }
        return true;
    }

    static int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    static void makeSet() {
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
    }
}