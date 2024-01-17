import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		int s = 0;
		int e = n - 1;
		long sum = 0;
		long min = Long.MAX_VALUE;
		String result = "";

		while (s < e) {
			sum = arr[s] + arr[e];
			if (Math.abs(sum) <= Math.abs(min)) {
				min = sum;
				result = arr[s] + " " + arr[e];
			}
			if (sum > 0) {
				e--;
			} else if (sum < 0) {
				s++;
			} else {
				System.out.println(result);
				return;
			}
		}
		System.out.println(result);
	}
}