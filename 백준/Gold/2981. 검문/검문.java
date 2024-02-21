import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.sun.source.tree.IfTree;

public class Main {
	static int n, m, start, end, sum, max;
	static int[] arr, inductions;
	static char[] chars;
	static int[][] dp;
	static boolean[] isPrime;
	static int[] dx = {-1, 0, 1};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		Arrays.sort(arr);
		int gcdVal = arr[1] - arr[0];
		for (int i = 2; i < n; i++) {
			gcdVal = gcd(gcdVal, arr[i] - arr[i - 1]);
		}
		for (int i = 2; i <= gcdVal; i++) {
			if (gcdVal % i == 0) {
				System.out.print(i + " ");
			}
		}

	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

}