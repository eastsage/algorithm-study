import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr1 = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr2 = new int[m];
		for (int i = 0; i < m; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			sb.append(findNum(arr2[i])).append(" ");
		}
		System.out.println(sb);
	}

	static int findNum(int key) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = (low + high) >>> 1;
			int midVal = arr1[mid];

			if (midVal < key) {
				low = mid + 1;
			} else if (midVal > key) {
				high = mid - 1;
			} else {
				return 1;
			}
		}
		return 0;
	}
}