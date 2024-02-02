import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, a, b, c;
	// static int[] arr, selected;
	static char[][] arr;
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new char[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j])
					continue;
				if (arr[i][j] == '-')
					dfs(i, j, true);
				else
					dfs(i, j, false);
				cnt++;
			}
		}

		System.out.println(cnt);

	}

	private static void dfs(int i, int j, boolean row) {
		visited[i][j] = true;
		if (row) {
			j++;
			if (j < m && arr[i][j] == '-')
				dfs(i, j, true);
		} else {
			i++;
			if (i < n && arr[i][j] != '-')
				dfs(i, j, false);
		}

	}
}