import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k, result;
	static int[][] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = (int)Math.floor(Math.sqrt(n));
		dp = new int[100_001];
		Arrays.fill(dp, -1);
		dp[1] = 1;

		recur(n);
		System.out.println(dp[n]);
	}

	public static int recur(int n) {
		if (n < 0) {
			return 99999999;
		}

		if (n == 0) {
			return 0;
		}

		if (dp[n] != -1) {
			return dp[n];
		}

		int tmp = 99999999;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n - i * i >= 0) {
				tmp = Math.min(tmp, recur(n - (i * i)) + 1);
			}
		}

		return dp[n] = tmp;
	}
}