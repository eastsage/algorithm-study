import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, x, y;
	static int[] arr, bead, bucket;
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		bead = new int[3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			bead[i] = Integer.parseInt(st.nextToken());
		}
		bucket = new int[2];
		dp = new int[555][555];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for (int[] ints : dp) {
				Arrays.fill(ints, -1);
			}
			recur(a, b);
			if (recur(a, b)) {
				System.out.println("A");
			} else {
				System.out.println("B");
			}
		}

	}
	static boolean recur(int a, int b) {
		if (a < 0 || b < 0) {
			return true;
		}
		if (dp[a][b] != -1) {
			return dp[a][b] == 1;
		}
		dp[a][b] = 0;
		for (int i : bead) {
			if (!recur(a - i, b) || !recur(a, b - i)) {
				dp[a][b] = 1;
			}
		}
		return dp[a][b] == 1;
	}
}