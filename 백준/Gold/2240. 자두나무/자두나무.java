import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int n, t, w, result;
    static int[][][] dp;
    static int[] arr;
    static boolean[] visited;
    static int[] dx = {-1, -0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr = new int[t];
        dp = new int[1010][35][3];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int r1 = recur(0, 0, 1);
        int r2 = recur(0, 1, 2);
        System.out.println(Math.max(r1, r2));

    }

    static int recur(int cur, int move, int tree) {
        if (cur == t) return 0; // 시간 초과
        if (move > w) return 0; // 이동 횟수 초과
        if (dp[cur][move][tree] != -1) return dp[cur][move][tree];

        // 현재 위치에서 자두를 받는 경우
        int tmp = recur(cur + 1, move, tree) + (arr[cur] == tree ? 1 : 0);
        // 이동 가능하면 이동 후 자두를 받는 경우 검사
        if (move < w) {
            tmp = Math.max(tmp, recur(cur + 1, move + 1, 3 - tree) + (arr[cur] == 3 - tree ? 1 : 0));
        }

        dp[cur][move][tree] = tmp;
        return tmp;
    }
}