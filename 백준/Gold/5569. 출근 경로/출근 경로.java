import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, w, h;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int[] arr, sortedArr;
    static int[][] map;
    static int[][][] dp;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h + 1][w + 1];
        dp = new int[h + 1][w + 1][2];

        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }

        recur(2, 1, 0);
        recur(1, 2, 1);
        int res = (dp[2][1][0] + dp[1][2][1]) % 100000;
        System.out.println(res);
    }

    static int recur(int x, int y, int dir) {
        if (x == h && y == w) return 1;
        if (dp[x][y][dir] != -1) return dp[x][y][dir];

        int tmp = 0;
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (dir != i) {
                if (!(nx == h && ny == w)) {
                    nx += dx[i];
                    ny += dy[i];
                }
            }
            if (nx > h || ny > w) continue;
            tmp += recur(nx, ny, i);
            tmp %= 100000;
        }

        // dp 배열에 결과 저장
        return dp[x][y][dir] = tmp;
    }
}