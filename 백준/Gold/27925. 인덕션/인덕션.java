import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, start, end;
	static int[] arr, inductions;
	static char[] chars;
	static int[][][][] dp;
	static int[] dx = {-1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[5010][10][10][10];
		for (int i = 0; i < 5010; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}

		System.out.println(recur(0, 0, 0, 0));
	}

	static int recur(int cur, int x, int y, int z) {
		if (cur == n) {
			return 0;
		}
		if (dp[cur][x][y][z] != -1) {
			return dp[cur][x][y][z];
		}

		int tmp = 2_000_000_000;
		tmp = Math.min(tmp, recur(cur + 1, arr[cur + 1], y, z) + Math.min(Math.abs(x - arr[cur + 1]), 10 - Math.abs(x - arr[cur + 1])));
		tmp = Math.min(tmp, recur(cur + 1, x, arr[cur + 1], z) + Math.min(Math.abs(y - arr[cur + 1]), 10 - Math.abs(y - arr[cur + 1])));
		tmp = Math.min(tmp, recur(cur + 1, x, y, arr[cur + 1]) + Math.min(Math.abs(z - arr[cur + 1]), 10 - Math.abs(z - arr[cur + 1])));
		return dp[cur][x][y][z] = tmp;
	}
}