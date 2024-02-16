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
		dp = new long[31][31];
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) return;
			for (long[] longs : dp) {
				Arrays.fill(longs, -1);
			}
			System.out.println(recur(n, 0));
		}

	}

	static long recur(int w, int h) {
		if (w == 0 && h == 0) {
			return 1;
		}
		if (dp[w][h] != -1) {
			return dp[w][h];
		}
		long tmp = 0;
		if (w != 0) {
			tmp += recur(w - 1, h + 1);
		}
		if (h != 0) {
			tmp += recur(w, h - 1);
		}
		return dp[w][h] = tmp;
	}
}