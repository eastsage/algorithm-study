import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, x, y;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int result = 0;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		recur(4);
		recur(7);
		System.out.println(result);
	}

	static void recur(long number) {
		if (number > y) {
			return;
		}
		if (number >= x) {
			result += 1;
		}
		recur(number * 10 + 4);
		recur(number * 10 + 7);
	}
}