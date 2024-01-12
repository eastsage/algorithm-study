import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, q;
	static int[][][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());

		map = new int[n + 1][n + 1][11];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int num = Integer.parseInt(st.nextToken());
				for (int k = 1; k <= 10; k++) {
					map[i][j][k] = map[i - 1][j][k] + map[i][j - 1][k] - map[i - 1][j - 1][k];
				}
				map[i][j][num]++;
			}
		}

		q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int cnt = 0;
			for (int j = 1; j <= 10; j++) {
				int cur = map[x2][y2][j] - map[x2][y1 - 1][j] - map[x1 - 1][y2][j] + map[x1 - 1][y1 - 1][j];
				if (cur != 0) {
					cnt++;
				}
			}
			sb.append(cnt + "\n");
		}

		System.out.print(sb);
	}
}