import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// g = c^2 - m^2
		// g = (c+m)(c-m)
		// c최대 = 50_001
		int g = Integer.parseInt(br.readLine());
		int m = 1;
		int c = 2;
		boolean hasValue = false;

		while (c <= 50001) {
			long val = (c * c) - (m * m);
			if (val == g) {
				System.out.println(c);
				hasValue = true;
			}
			if (val > g) {
				m++;
			} else {
				c++;
			}
		}
		if (!hasValue) {
			System.out.println(-1);
		}

	}
}