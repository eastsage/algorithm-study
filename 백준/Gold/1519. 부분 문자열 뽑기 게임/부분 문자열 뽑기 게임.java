import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, x, y;
	static String s;
	static int[] arr, bead, bucket;
	static int[] dp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		s = br.readLine();
		n = Integer.parseInt(s);
		dp = new int[1_000_010];
		Arrays.fill(dp, -99);

		System.out.println(recur(n));
	}
	static int recur(int cur) {
		if (cur < 10) {
			return -1;
		}
		if (dp[cur] != -99) {
			return dp[cur];
		}
		List<Integer> subStrings = getSubStrings(cur);
		Collections.sort(subStrings, Collections.reverseOrder());
		int tmp = Integer.MAX_VALUE;
		for (Integer subString : subStrings) {
			if (recur(cur - subString) == -1) {
				tmp = Math.min(tmp, subString);
			}
		}
		dp[cur] = tmp;
		if (tmp == Integer.MAX_VALUE) {
			dp[cur] = -1;
		}
		return dp[cur];
	}
	static List<Integer> getSubStrings(int num) {
		String str = String.valueOf(num);
		List<Integer> list = new ArrayList<>();
		for (int i = str.length() - 1; i > 0; i--) {
			for (int j = 0; j <= str.length() - i; j++) {
				int sub = Integer.parseInt(str.substring(j, j + i));
				if (sub != 0) {
					list.add(sub);
				}
			}
		}
		return list;
	}
}