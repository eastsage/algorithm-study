import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, k, l, c;
	static char[] arr, code;
	static List<Character> vowels = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		code = new char[l];
		arr = new char[c];

		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');

		arr = br.readLine().replace(" ", "").toCharArray();
		Arrays.sort(arr);
		recur(0, 0);
	}

	static void recur(int depth, int idx) {
		if (depth >= l) {
			int cnt = 0;
			for (char alpha : code) {
				if (vowels.contains(alpha)) {
					cnt++;
				}
			}
			if (cnt >= 1 && cnt <= l - 2) {
				System.out.println(new String(code));
			}
			return;
		}

		if (idx >= c) {
			return;
		}

		code[depth] = arr[idx];
		recur(depth + 1, idx + 1); // 현재 문자를 선택하는 경우
		recur(depth, idx + 1); // 현재 문자를 선택하지 않는 경우
	}
}