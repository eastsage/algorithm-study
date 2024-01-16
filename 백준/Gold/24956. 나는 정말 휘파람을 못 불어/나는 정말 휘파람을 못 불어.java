import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static long[][] matrix;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		long sum[] = new long[3];
		long result = 0;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (c == 'W') {
				sum[0]++;
			} else if (c == 'H') {
				sum[1] += sum[0];
			} else if (c == 'E') {
				result = (2 * result + sum[2]) % 1_000_000_007;
				sum[2] += sum[1];
			}
		}
		System.out.println(result);
	}
}