import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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

		List<Pair> pairs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			pairs.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(pairs, (o1, o2) -> {
			if (o1.x == o2.x)
				return o1.y - o2.y;
			return o1.x - o2.x;
		});

		int cnt = 0;
		for (Pair pair : pairs) {
			int x = pair.x;
			int y = pair.y;
			if (binarySearch(pairs, x + a, y) &&
				binarySearch(pairs, x, y + b) &&
				binarySearch(pairs, x + a, y + b)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static boolean binarySearch(List<Pair> pairs, int x, int y) {
		int low = 0;
		int high = pairs.size() - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			Pair pair = pairs.get(mid);

			if (pair.x == x && pair.y == y) {
				return true;
			} else if (pair.x < x || (pair.x == x && pair.y < y)) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}

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