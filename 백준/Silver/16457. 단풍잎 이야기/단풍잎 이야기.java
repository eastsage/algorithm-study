import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k, result;
	static int[][] arr;
	static Integer[] skills, keys;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[m][k];
		keys = new Integer[n];
		Set<Integer> tmp = new HashSet<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				tmp.add(arr[i][j]);
			}
		}

		skills = tmp.toArray(new Integer[0]);
		recur(0, 0);
		System.out.println(result);
	}

	static void recur(int depth, int start) {
		if (depth == n || skills.length <= depth) {
			int cnt = 0;
			List<Integer> cur = new ArrayList<>(Arrays.asList(keys));

			for (int[] ints : arr) {
				int tmp = 0;
				for (int skill : ints) {
					if (cur.contains(skill)) {
						tmp++;
					}
				}
				if (tmp >= k) {
					cnt++;
				}
			}
			result = Math.max(result, cnt);
			return;
		}

		for (int i = start; i < skills.length; i++) {
			keys[depth] = skills[i];
			recur(depth + 1, i + 1);
		}
	}
}