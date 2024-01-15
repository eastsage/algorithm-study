import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] prefixSum;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		prefixSum = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
		}
		int result = -9999999;
		for (int i = k; i <= n; i++) {
			result = Math.max(result, prefixSum[i] - prefixSum[i - k]);
		}

		System.out.println(result);
	}
}