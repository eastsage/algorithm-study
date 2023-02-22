import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n, min;
    static Loc[] customer;
    static Loc company, home;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            min = Integer.MAX_VALUE;
            company = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            customer = new Loc[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                customer[i] = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            bfs(0, 0, company);
            System.out.println("#" + testCase + " " + min);
        }
    }

    static void bfs(int cnt, int sum, Loc loc) {
        if (cnt == n) {
            min = Math.min(min, sum + loc.getDist(home));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(cnt + 1, sum + loc.getDist(customer[i]), customer[i]);
                visited[i] = false;
            }
        }
    }
}

class Loc {
    int y;
    int x;

    public Loc(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getDist(Loc loc) {
        return Math.abs(this.y - loc.y) + Math.abs(this.x - loc.x);
    }
}