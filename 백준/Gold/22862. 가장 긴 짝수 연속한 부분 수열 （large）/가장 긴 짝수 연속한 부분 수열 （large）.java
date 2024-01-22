import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[n + 1];
		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			if (num % 2 != 1) {
				check[i] = true;
			}
		}
		int s = 1, e = 1;
		int cnt = 0, max = 0;
		while (e <= n) {
			if (cnt < k) {
				if (!check[e]) {
					cnt++;
				}
				e++;
				max = Math.max(max, e - s - cnt);
			} else if (check[e]) {
				e++;
				max = Math.max(max, e - s - cnt);
			} else if (cnt == k && !check[e]) {
				if (!check[s]) {
					cnt--;
				}
				s++;
			}
		}
		System.out.println(max);
	}
}