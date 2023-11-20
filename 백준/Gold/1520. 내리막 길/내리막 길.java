import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int m, n, result;
    static int[][] dp, map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(recur2(0, 0));
    }

    static int recur2(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        int tmp = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (map[x][y] > map[nx][ny]) {
                tmp += recur2(nx, ny);
            }
        }
        dp[x][y] = tmp;
//        System.out.println("x = " + x + ",y = " + y + ",dp = " + dp[x][y]);
        return dp[x][y];
    }

    static int recur(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            result++;
            return 1;
        }
        int tmp = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (map[x][y] > map[nx][ny]) {
                tmp+=recur(nx, ny);
            }
        }
        return tmp;
    }
}