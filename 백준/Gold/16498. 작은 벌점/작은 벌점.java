import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, a, b, c;
	static List<Integer>[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());

		int[] A = new int[Integer.parseInt(st.nextToken())];
		int[] B = new int[Integer.parseInt(st.nextToken())];
		int[] C = new int[Integer.parseInt(st.nextToken())];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < B.length; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C.length; i++) {
			C[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(B);
		Arrays.sort(C);
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (result == 0) {
				break;
			}

			int tmpA = A[i];
			int tmpB = binarySearch(tmpA, B);
			int tmpC1 = binarySearch(tmpB, C);
			int tmpC2 = binarySearch(tmpA, C);

			int max = Math.max(tmpA, Math.max(tmpB, tmpC1));
			int min = Math.min(tmpA, Math.min(tmpB, tmpC1));
			result = Math.min(result, Math.abs(max - min));

			max = Math.max(tmpA, Math.max(tmpB, tmpC2));
			min = Math.min(tmpA, Math.min(tmpB, tmpC2));
			result = Math.min(result, Math.abs(max - min));
		}
		System.out.println(result);
	}

	static int binarySearch(int select, int[] arr) {
		int s = 0;
		int e = arr.length - 1;
		int mid = (s + e) / 2;
		int nearest = arr[mid];
		while (s <= e) {
			mid = (s + e) >>>1;
			if (arr[mid] == select) {
				return select;
			} else if (arr[mid] < select) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
			if (check(arr[mid], nearest, select)) {
				nearest = arr[mid];
			}
		}
		return nearest;
	}

	public static boolean check(int num, int near, int t) {
		return Math.abs(num - t) < Math.abs(near - t);
	}
}