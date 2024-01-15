import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// S = 2, K = -1
		String s = br.readLine();
		int[] v = new int[s.length() + 1];
		int[] cnt = new int[s.length() + 1];
		Map<Integer, Integer> minIdx = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			int n = 0;
			if (s.charAt(i) == 'S') n = 2;
			if (s.charAt(i) == 'K') n = -1;
			v[i + 1] = v[i] + n;
			cnt[i + 1] = cnt[i] + (n == 0 ? 0 : 1);
		}

		int ans = -1;

		for (int i = 0; i < s.length() + 1; i++) {
			if (!minIdx.containsKey(v[i])) {
				minIdx.put(v[i], i);
			} else {
				int midx = minIdx.get(v[i]);
				if (cnt[midx] == cnt[i]) continue;
				ans = Math.max(ans, i - midx);
			}
		}

		System.out.println(ans);

	}
}