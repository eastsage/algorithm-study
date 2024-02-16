import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static int[][] map;
	static int[] dp;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		Arrays.fill(dp, -1);
		dp[1] = 1;
		if (n > 1) {
			dp[2] = 2;
		}
		System.out.println(recur(n));
	}

	static int recur(int cur) {
		if (dp[cur] != -1) {
			return dp[cur];
		}
		return dp[cur] = (recur(cur - 1) + recur(cur - 2)) % 10007;
	}
}