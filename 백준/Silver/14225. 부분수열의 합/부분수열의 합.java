import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static boolean[] visited = new boolean[20_000_001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		recur(0, 0);
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				System.out.println(i);
				return;
			}
		}

	}

	static void recur(int cur, int sum) {
		if (cur == n) {
			visited[sum] = true;
			return;
		}
		recur(cur + 1, sum + arr[cur]);
		recur(cur + 1, sum);
	}
}