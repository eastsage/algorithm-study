import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, t, cnt;
	static int[][] arr;
	static char[] chars;
	static int[][] dp;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		int[][] tmp = new int[n][m * 3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int sum = 0;
				for (int k = 0; k < 3; k++) {
					sum += Integer.parseInt(st.nextToken());
				}
				arr[i][j] = sum / 3;
			}
		}
		t = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] >= t) {
					arr[i][j] = 255;
				} else {
					arr[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 255 && !visited[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}
	static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] poll = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || arr[nx][ny] == 0) {
					continue;
				}
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
	}

}