import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, x, y;
	static int[] arr, dp;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		dp = new int[1010];
		Arrays.fill(dp, -1);
		dp[1] = 1; //SK
		dp[2] = 0; //CY
		dp[3] = 1;
		dp[4] = 1;
		recur(n);
		if (dp[n] == 1) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}

	static int recur(int cur) {
		if (cur < 0) {
			return 0;
		}
		if (dp[cur] != -1) {
			return dp[cur];
		}
		if (recur(cur - 1) == 1 && recur(cur - 3) == 1 && recur(cur - 4) == 1) {
			dp[cur] = 0;
		} else {
			dp[cur] = 1;
		}
		return dp[cur];
	}
}