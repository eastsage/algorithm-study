import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int d, p;
    static int[] l, c;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        l = new int[p];
        c = new int[p];
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            l[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[d + 1];
        Arrays.fill(dp, -1);
        dp[0] = Integer.MAX_VALUE; // 길이 0일 때, 최대 용량은 무한으로 간주

        for (int i = 0; i < p; i++) {
            for (int j = d; j >= l[i]; j--) {
                if (dp[j - l[i]] != -1) {
                    dp[j] = Math.max(dp[j], Math.min(dp[j - l[i]], c[i]));
                }
            }
        }

        System.out.println(dp[d]);
    }
}