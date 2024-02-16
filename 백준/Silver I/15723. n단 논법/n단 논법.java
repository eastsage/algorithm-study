import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, start, end;
	static int[][] arr = new int[26][26];
	static int[][] dp;
	static int[] dx = {-1, 0, 1};

	/**
	 * a = b
	 * c = a
	 * c = b
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				if (i != j)
					arr[i][j] = 1000;
			}
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			start = st.nextToken().charAt(0) - 'a'; // 해당 데이터를 숫자로 변환
			st.nextToken(); // is 부분 날려버림
			end = st.nextToken().charAt(0) - 'a'; // 해당 데이터를 숫자로 변환
			arr[start][end] = 1;
		}
		for (int k = 0; k < 26; k++) { // 플로이드 와샬
			for (int i = 0; i < 26; i++) {
				if (i == k)
					continue;
				for (int j = 0; j < 26; j++) {
					if (i == j || k == j)
						continue;
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}

		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			start = st.nextToken().charAt(0) - 'a';
			st.nextToken();
			end = st.nextToken().charAt(0) - 'a';
			if (arr[start][end] != 0 && arr[start][end] < 1000)
				System.out.println("T");
			else
				System.out.println("F");
		}

	}
}