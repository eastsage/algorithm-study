import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, start, end;
	static int[] arr;
	static char[] drugs;
	static int[][] dp;
	static int[] dx = {-1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		drugs = br.readLine().toCharArray();
		dp = new int[1515][1515];
		for (int[] ints : dp) {
			Arrays.fill(ints, -1);
		}
		System.out.println(recur(0, drugs.length - 1, 'D'));

	}

	static int recur(int l, int r, char prev) {
		if (l > r) return 0;
		if (dp[l][r] != -1) return dp[l][r];

		int tmp = 0;
		if ((drugs[l] == 'B' && prev == 'D') || (drugs[l] == 'L' && prev == 'B') || (drugs[l] == 'D' && prev == 'L')) {
			tmp = Math.max(recur(l + 1, r, drugs[l]) + 1, tmp);
		}
		if ((drugs[r] == 'B' && prev == 'D') || (drugs[r] == 'L' && prev == 'B') || (drugs[r] == 'D' && prev == 'L')) {
			tmp = Math.max(recur(l, r - 1, drugs[r]) + 1, tmp);
		}
		return dp[l][r] = tmp;
	}

}