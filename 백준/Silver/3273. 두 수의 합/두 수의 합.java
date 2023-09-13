import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		int k = Integer.parseInt(br.readLine());
		int s = 0, result = 0;
		int e = n - 1;

		while (s < e) {
			if (arr[s] + arr[e] > k) {
				e--;
			} else if (arr[s] + arr[e] < k) {
				s++;
			} else {
				result++;
				e--;
				s++;
			}
		}
		System.out.println(result);

	}
}