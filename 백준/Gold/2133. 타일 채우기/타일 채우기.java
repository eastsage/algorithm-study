import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] hi, arc;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dp = new int[31];
        Arrays.fill(dp, -1);
        dp[0] = 1; // 아무 타일도 놓지 않는 경우
        dp[1] = 0; // 2*1 크기의 타일은 채울 수 없음
        dp[2] = 3; // 2*2 크기의 타일을 채우는 경우의 수는 3가지

        System.out.println(recur(n));
    }

    static int recur(int cur) {
        if (cur % 2 != 0) return 0; // 홀수일 경우 0을 반환
        if (dp[cur] != -1) return dp[cur]; // 이미 계산된 경우 값을 반환
        dp[cur] = recur(cur - 2) * 3; // 기본 점화식 부분
        for (int i = cur - 4; i >= 0; i -= 2) {
            dp[cur] += recur(i) * 2; // 추가 패턴을 고려한 부분
        }
        return dp[cur];
    }
}