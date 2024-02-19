import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.sun.source.tree.IfTree;

public class Main {
	static int n, m, start, end, sum;
	static int[] arr, inductions;
	static char[] chars;
	static int[][] dp;
	static int[] dx = {-1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}

		dp = new int[2501][2501];
		for (int[] ints : dp) {
			Arrays.fill(ints, -1);
		}
		System.out.println(recur(0, 0, 0));
	}

	static int recur(int cur, int x, int y) {
		if (cur == n) {
			int z = sum - x - y;
			if (z <= x && z <= y) {
				return z;
			}
			return -2_000_000_000;
		}
		if (dp[x][y] != -1) {
			return dp[x][y];
		}
		int tmp = 0;
		tmp = Math.max(tmp, recur(cur + 1, x + arr[cur], y));
		tmp = Math.max(tmp, recur(cur + 1, x, y + arr[cur]));
		tmp = Math.max(tmp, recur(cur + 1, x, y));
		dp[x][y] = tmp;
		return tmp;
	}
}