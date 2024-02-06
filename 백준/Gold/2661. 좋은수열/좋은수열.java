import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k, cnt;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		recur("");
	}

	static void recur(String str) {
		if (str.length() == n) {
			System.out.println(str);
			System.exit(0);
		}
		for (int i = 1; i <= 3; i++) {
			if (isValid(str + i)) {
				recur(str + i);
			}
		}
	}

	static boolean isValid(String str) {
		for (int i = 1; i <= str.length() / 2; i++) {
			String s1 = str.substring(str.length() - i * 2, str.length() - i);
			String s2 = str.substring(str.length() - i, str.length());
			if (s1.equals(s2)) {
				return false;
			}
		}
		return true;
	}
}