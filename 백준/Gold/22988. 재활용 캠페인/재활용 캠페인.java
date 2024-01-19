import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static boolean[] isPrime;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long x = Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine());
		List<Long> list = new ArrayList<>();
		int result = 0;
		for (int i = 0; i < n; i++) {
			long input = Long.parseLong(st.nextToken());
			if (input >= x) {
				result++;
				continue;
			}
			list.add(input);
		}
		Collections.sort(list);

		int s = 0;
		int e = list.size() - 1;
		int cnt = 0;
		while (s < e) {
			if ((list.get(s) + list.get(e)) * 2 >= x) {
				cnt++;
				s++;
				e--;
			} else {
				s++;
			}
		}
		cnt += (list.size() - (cnt * 2)) / 3;
		result += cnt;
		System.out.println(result);
	}
}