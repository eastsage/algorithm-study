import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, start, end;
	static int[] arr;
	static long[][] dp;
	static int[] dx = {-1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n - 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n - 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		end = Integer.parseInt(st.nextToken());

		dp = new long[n - 1][1000];
		for (long[] longs : dp) {
			Arrays.fill(longs, -1);
		}
		System.out.println(recur(1, arr[0]));
	}

	static long recur(int cur, int sum) {
		if (sum < 0 || sum > 20) {
			return 0;
		}
		if (cur == n - 1) {
			if (sum == end) {
				return 1;
			}
			return 0;
		}
		if (dp[cur][sum] != -1) {
			return dp[cur][sum];
		}
		dp[cur][sum] = recur(cur + 1, sum + arr[cur]) + recur(cur + 1, sum - arr[cur]);
		return dp[cur][sum];
	}
}