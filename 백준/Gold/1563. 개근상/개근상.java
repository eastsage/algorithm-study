import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, start, end;
	static int[] arr, inductions;
	static char[] chars;
	static long[][][] dp;
	static int[] dx = {-1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		dp = new long[1001][3][4];
		for (long[][] longs : dp) {
			for (long[] aLong : longs) {
				Arrays.fill(aLong, -1);
			}
		}
		System.out.println(recur(0, 0, 0));
	}
	static long recur(int cur, int l, int a) {
		if (cur == n) {
			return 1;
		}
		if (dp[cur][l][a] != -1) {
			return dp[cur][l][a];
		}
		int tmp = 0;
		tmp += recur(cur + 1, l, 0);
		if (l < 1) {
			tmp += recur(cur + 1, l + 1, 0);
		}
		if (a < 2) {
			tmp += recur(cur + 1, l, a + 1);
		}
		return dp[cur][l][a] = tmp % 1_000_000;
	}
}