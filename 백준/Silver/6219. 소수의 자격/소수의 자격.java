import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int a, b, d, result;
	static boolean[] notPrime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		String sd = String.valueOf(d);

		notPrime = new boolean[b + 1];
		int max = (int) Math.sqrt(b);
		for (int i = 2; i <= max; i++) {
			if (!notPrime[i]) {
				int num = 1;
				while (i * ++num <= b) {
					notPrime[i * num] = true;
				}
			}
		}


		for (int i = a; i <= b; i++) {
			if (!notPrime[i]) {
				if (String.valueOf(i).contains(sd)) {
					result++;
				}
			}
		}

		System.out.println(result);
	}
}