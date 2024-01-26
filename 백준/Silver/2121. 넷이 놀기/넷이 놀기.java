import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()); //가로
		int b = Integer.parseInt(st.nextToken()); //세로

		Set<Pair> pairs = new HashSet<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			pairs.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int cnt = 0;
		for (Pair pair : pairs) {
			int x = pair.x;
			int y = pair.y;
			if (pairs.contains(new Pair(x + a, y)) &&
				pairs.contains(new Pair(x, y + b)) &&
				pairs.contains(new Pair(x + a, y + b))) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	// static boolean binarySearch(int low, int high, int key, char type) {
	// 	while (low <= high) {
	// 		int mid = (low + high) >>> 1;
	// 		int midVal = arr[mid][0];
	// 		if (type == 'y') {
	// 			midVal = arr[mid][1];
	// 		}
	//
	// 		if (midVal < key)
	// 			low = mid + 1;
	// 		else if (midVal > key)
	// 			high = mid - 1;
	// 		else {
	// 			return true;
	// 		}
	// 	}
	// 	return false;
	// }
	private static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Pair pair = (Pair)o;
			return x == pair.x && y == pair.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
}