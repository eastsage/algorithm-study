import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n, m, x, y;
	static String s;
	static int[] arr, bead, bucket;
	static int[] dp;
	static int[][] sum;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n + 1];
		Arrays.fill(dp, -1);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			m = Math.max(m, recur(i));
		}
		System.out.println(m);
	}

	static int recur(int cur) {

		if (dp[cur] != -1) {
			return dp[cur];
		}
		dp[cur] = 1;
		for (int i = cur - 1; i >= 0; i--) {
			if (arr[cur] > arr[i]) {
				dp[cur] = Math.max(dp[cur], recur(i) + 1);
			}
		}
		return dp[cur];
	}
}