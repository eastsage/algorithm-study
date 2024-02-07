import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static long result;
	static boolean[] brokenBtn = new boolean[10];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		if (m != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				int num = Integer.parseInt(st.nextToken());
				brokenBtn[num] = true;
			}
		}

		if (n == 100) {
			System.out.println(0);
			return;
		}

		result = Math.abs(n - 100);
		recur(0, 0);
		System.out.println(result);
	}

	static void recur(int cur, int click) {
		for (int i = 0; i < 10; i++) {
			if (!brokenBtn[i]) {
				int btn = click * 10 + i;
				int cnt = Math.abs(n - btn) + String.valueOf(btn).length();
				result = Math.min(cnt, result);

				if (cur < 6) {
					recur(cur + 1, btn);
				}
			}
		}
	}
}