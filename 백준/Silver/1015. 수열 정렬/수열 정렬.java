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

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		int[][] A = new int[n][2];
		int[] B = new int[n];
		String[] tmp = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			A[i][0] = Integer.parseInt(tmp[i]);
			A[i][1] = i;
		}

		// 정렬 수행
		sort(A);

		for (int i = 0; i < n; i++) {
			int index = A[i][1];
			B[index] = i;
		}

		for (int b : B) {
			sb.append(b).append(" ");
		}

		System.out.println(sb.toString().trim());

	}
	private static void sort(int[][] A) {
		Arrays.sort(A, (next, cur) ->
		{
			if (next[0] < cur[0]) {
				return -1;
			}

			else if (next[0] > cur[0]) {
				return 1;
			}

			else {
				return Integer.compare(next[1], cur[1]);
			}
		});
	}
}