import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long a = Long.parseLong(st.nextToken());
		long k = 0;
		/**
		 * 제곱수 찾기
		 */
		long cur = 1;
		while (cur < n) {
			cur *= a;
			k += n / cur;
		}
		System.out.println(k);
	}
}