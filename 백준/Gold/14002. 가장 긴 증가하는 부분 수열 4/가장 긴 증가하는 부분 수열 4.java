import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, x, y;
	static String s;
	static int[] arr, bead, bucket;
	static int[] dp, revArr;
	static int[][] sum;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		dp = new int[n + 1];
		revArr = new int[n + 1]; // 역추적

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(dp, -1);

		int max = 0;
		int lo = 0;
		for (int i = 1; i < n + 1; i++) {
			int len = recur(i);
			if (len > max) {
				max = len;
				lo = i;
			}
		}

		if (revArr[lo] == 0) {
			sb.append(arr[lo]);
		} else {
			// 역추적
			traceBack(lo);
		}
		System.out.println(max);
		System.out.println(sb);
	}

	private static void traceBack(int lo) {
		if (revArr[lo] != lo) {
			traceBack(revArr[lo]);
			sb.append(arr[lo]).append(" ");
		}
	}

	private static int recur(int cur) {
		if (dp[cur] != -1) {
			return dp[cur];
		}
		dp[cur] = 1;

		for (int i = cur - 1; i > 0; i--) {
			if (arr[cur] > arr[i]) {
				if (dp[i] + 1 > dp[cur]) {
					dp[cur] = dp[i] + 1;
					revArr[cur] = i;
				}
			}
		}
		return dp[cur];
	}

}