import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[][] students = new int[4][n];

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					students[i][j] = Integer.parseInt(st.nextToken());
				}
			} // input END

			int[] sumOfClass1 = new int[n * n];
			int[] sumOfClass2 = new int[n * n];
			int idx = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sumOfClass1[idx] = students[0][i] + students[1][j];
					sumOfClass2[idx++] = students[2][i] + students[3][j];
				}
			}
			Arrays.sort(sumOfClass1);
			Arrays.sort(sumOfClass2);

			int s = 0;
			int e = sumOfClass1.length - 1;
			int minDiff = Integer.MAX_VALUE;
			int result = 0;

			while (s < sumOfClass1.length && e >= 0) {
				int sum = sumOfClass1[s] + sumOfClass2[e];
				int diff = k - sum;
				if (Math.abs(minDiff) == Math.abs(diff)) {
					if (diff > 0) {
						minDiff = diff;
						result = sum;
					}
				} else if (Math.abs(minDiff) > Math.abs(diff)) {
					minDiff = diff;
					result = sum;
				}
				if (sum == k) {
					result = k;
					break;
				} else if (sum > k) {
					e--;
				} else if (sum < k) {
					s++;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}