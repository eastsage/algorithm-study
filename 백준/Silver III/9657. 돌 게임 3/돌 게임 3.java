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
		dp = new int[1000001];
		Arrays.fill(dp, -1);
		dp[1] = 1;
		dp[2] = 0;
		dp[3] = 1;
		dp[4] = 1;
		dp[5] = 1;

		recur(n);

		if (dp[n] == 1) System.out.println("SK");
		else System.out.println("CY");
	}

	static int recur(int cur) {
		if (dp[cur] != -1) {
			return dp[cur];
		}

		if (recur(cur - 1) == 0 || recur(cur - 3) == 0 || recur(cur - 4) == 0) {
			dp[cur] = 1;
		} else {
			dp[cur] = 0;
		}
		return dp[cur];
	}
}