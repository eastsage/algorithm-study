import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		if (n % 2 == 1) {
			System.out.println(arr[n / 2]);
		} else {
			System.out.println(arr[n / 2 - 1]);
		}
	}
}