import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, a, b, c;
	static int[] arr, selected;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int x = Integer.parseInt(br.readLine());
		int tmp = 0;
		int cnt = 0;
		int result = x;
		int stick = 64;
		while (true) {
			if (x == 64) {
				cnt++;
				break;
			}
			stick /= 2;
			if (stick <= x) {
				tmp += stick;
				cnt++;
				if (result == tmp) {
					break;
				}
				x -= stick;
			}
		}
		System.out.println(cnt);


	}
}