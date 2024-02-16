import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {-1, 0, 1};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][3];
		dp = new int[n + 1][3];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}

		recur1(0, 1);
		StringBuilder sb = new StringBuilder();
		sb.append(dp[0][1]).append(" ");
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(dp[i], -1);
		}
		recur2(0, 1);

		sb.append(dp[0][1]);
		System.out.println(sb);
	}

	static int recur1(int cur, int idx) {
		if (cur == n) {
			return 0;
		}
		if (dp[cur][idx] != -1) {
			return dp[cur][idx];
		}
		int tmp = 0;
		for (int i = 0; i < 3; i++) {
			int nxt = idx + dx[i];
			if (nxt < 0 || nxt > 2) continue;
			tmp = Math.max(tmp, recur1(cur + 1, nxt) + map[cur][nxt]);
		}
		return dp[cur][idx] = tmp;
	}
	static int recur2(int cur, int idx) {
		if (cur == n) {
			return 0;
		}
		if (dp[cur][idx] != -1) {
			return dp[cur][idx];
		}
		int tmp = 2_000_000_000;
		for (int i = 0; i < 3; i++) {
			int nxt = idx + dx[i];
			if (nxt < 0 || nxt > 2) continue;
			tmp = Math.min(tmp, recur2(cur + 1, nxt) + map[cur][nxt]);
		}
		return dp[cur][idx] = tmp;
	}
}