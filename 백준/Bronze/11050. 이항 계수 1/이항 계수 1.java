import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int[][] arr;
    static int[][] map;
    static int[] dp;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[n + 100];
        Arrays.fill(dp, -1);

        System.out.println(factorial(n) / (factorial(n - k) * factorial(k)));
    }

    static int factorial(int cur) {
        // factorial(0) == 1 이다. 
        if (cur <= 1) {
            return 1;
        }
        if (dp[cur] != -1) return dp[cur];


        return dp[cur] = cur * factorial(cur - 1);
    }

}