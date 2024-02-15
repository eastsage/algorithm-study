import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k, result;
	static int[][] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = (int)Math.floor(Math.sqrt(n));
		dp = new int[100_001];
		Arrays.fill(dp, -1);
		dp[1] = 1;

		ans(n);
		System.out.println(dp[n]);
	}

	public static void ans(int n) {


		dp[1] = 1;

		for(int i=2; i<=n; i++) {
			int min=100001;

			for(int j=1; j<=(int)i/2; j++) {

				if(j*j == i) {
					min = 1;
					break;
				}
				else{
					min = Math.min(min, dp[j]+dp[i-j]);
				}

			}
			dp[i] = min;
		}
		return;
	}
}