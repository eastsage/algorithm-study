import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, k, cnt;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		selected = new int[n];

		recur(n, 0);
		if (sb.length() == 0)
			System.out.println(-1);
	}

	static void recur(int cur, int depth) {
		if (cur == 0) {
			if (++cnt == k) {
				for (int i = 0; i < depth; i++) {
					sb.append(selected[i]).append("+");
				}
				sb.deleteCharAt(2 * depth - 1);
				System.out.println(sb);
			}
			return;
		}

		for (int i = 1; i < 4; i++) {
			selected[depth] = i;
			if (cur - i < 0) {
				return;
			}
			recur(cur - i, depth + 1);
		}
	}
}