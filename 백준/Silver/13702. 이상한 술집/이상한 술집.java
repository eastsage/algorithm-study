import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(arr[i], max);
		}
		Arrays.sort(arr);
		int s = 0;
		int e = max;
		int result = 0;
		while (s <= e) {
			int mid = (s + e) >>> 1;
			if (isValid(mid)) {
				s = mid + 1;
				result = mid;
			} else {
				e = mid - 1;
			}
		}
		System.out.println(result);
	}
	static boolean isValid(int mid) {
		int cnt = 0;
		if (mid == 0) {
			return true;
		}
		for (int i = 0; i < n; i++) {
			cnt += arr[i] / mid;
		}
		return cnt >= k;
	}
}