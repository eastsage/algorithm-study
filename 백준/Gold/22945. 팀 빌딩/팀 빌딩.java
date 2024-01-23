import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] devs;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		devs = new int[n];
		for (int i = 0; i < n; i++) {
			devs[i] = Integer.parseInt(st.nextToken());
		}

		int s = 0, e = n - 1;
		int max = 0;
		while (s < e) {
			max = Math.max(max, calc(s, e));
			if (devs[s] < devs[e]) {
				s++;
			} else {
				e--;
			}
		}
		System.out.println(max);
	}

	static int calc(int a, int b) {
		return Math.min(devs[a], devs[b]) * (b - a - 1);
	}
}