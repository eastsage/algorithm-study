import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final long INF = Long.MAX_VALUE / 2;
    static int n, m, a, b;
    static int[][] arr;
    static int[][] map;
    static int[][][][] dp;
    static boolean[] visible;
    static List<long[]>[] edges;

    public static void main(String[] args) throws IOException {
        init();
        dp = new int[n + 1][a + 1][n + 1][2];
        for (int[][][] ints : dp) {
            for (int[][] anInt : ints) {
                for (int[] ints1 : anInt) {
                    Arrays.fill(ints1, -1);
                }
            }
        }
        System.out.println(recur(0, 0, 0, 0));
    }

    static int recur(int cur, int rest, int study, int prev) {
        if (cur == n) {
            if (study < b) return -2_000_000_000;
            return 0;
        }
        if (dp[cur][rest][study][prev] != -1) return dp[cur][rest][study][prev];
        int tmp = -2_000_000_000;
        tmp = Math.max(recur(cur + 1, rest, study + 1, 0) + arr[cur][0], tmp);
        tmp = Math.max(recur(cur + 1, rest, study + 1, 0) + arr[cur][1], tmp);
        if (prev == 0) {
            tmp = Math.max(recur(cur + 1, rest, study, 1) + arr[cur][2], tmp);
        }
        if (rest < a) {
            tmp = Math.max(recur(cur + 1, rest + 1, study, 0) + arr[cur][3], tmp);
        }
        dp[cur][rest][study][prev] = tmp;
        return tmp;
    }


    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}