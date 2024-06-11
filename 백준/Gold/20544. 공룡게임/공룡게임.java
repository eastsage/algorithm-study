import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static long[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new long[1010][1010][3][3];

        for (int i = 0; i < 1010; i++) {
            for (int j = 0; j < 1010; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }

        System.out.println(recur(1, 0, false, 0) % 1000000007);
    }

    static long recur(int cur, int total, boolean two, int cnt) {
        if (cur > n) return 0;

        if (cur == n) {
            if (two) return 1;
            return 0;
        }

        int twoIdx = two ? 1 : 0;
        if (dp[cur][total][twoIdx][cnt] != -1) return dp[cur][total][twoIdx][cnt] % 1000000007;

        long ret = 0;

        if (cnt <= 1) {
            if (total + 1 < 4) ret += recur(cur + 1, total + 1, two, cnt + 1) % 1000000007;
            if (total + 2 < 4) ret += recur(cur + 1, total + 2, true, cnt + 1) % 1000000007;
        }
        ret += recur(cur + 1, 0, two, 0) % 1000000007;

        dp[cur][total][twoIdx][cnt] = ret % 1000000007;

        return dp[cur][total][twoIdx][cnt];
    }
}