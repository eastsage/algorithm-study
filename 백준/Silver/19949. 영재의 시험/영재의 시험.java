import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt;
	static int[] arr;
	static int n = 10;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		backTracking(new int[n], 0, 0);
		System.out.println(cnt);
	}

	static void backTracking(int[] arr, int solCnt, int cur) {
		if (n - cur + solCnt < 5) {
			return;
		}

		if (cur == n) {
			if (solCnt >= 5) {
				cnt++;
			}
		} else {
			int notAnswer = 0;
			if (cur >= 2) {
				if (arr[cur - 1] == arr[cur - 2]) {
					notAnswer = arr[cur - 1];
				}
			}
			for (int i = 1; i <= 5; i++) {
				if (i == notAnswer) {
					continue;
				}

				arr[cur] = i;
				if (Main.arr[cur] == i) {
					backTracking(arr, solCnt + 1, cur + 1);
				} else {
					backTracking(arr, solCnt, cur + 1);
				}
				arr[cur] = 0;
			}
		}
	}
}