import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static int a, d;
	static int[] ans = new int[1001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ans[1] = 2;
		for (int i = 2; i <= 1000; ++i) {
			int n = 0;
			for (int j = 1; j <= i; ++j) {
				if (gcd(i, j) == 1) {
					++n;
				}
			}
			ans[i] = ans[i - 1] + n;
		}

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(ans[N] * 2 - 1);
		}
	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}