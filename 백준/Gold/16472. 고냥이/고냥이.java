import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static boolean[] isPrime;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int cnt = 0, result = 0;
		int s = 0, e = -1;
		int[] alphabet = new int[26];
		while (++e < str.length()) {
			if (alphabet[str.charAt(e) - 'a']++ == 0) {
				cnt++;
			}
			while (n < cnt && s < e) {
				if (--alphabet[str.charAt(s++) - 'a'] == 0) {
					cnt--;
				}
			}
			result = Math.max(result, e - s + 1);
		}

		System.out.println(result);
	}
}