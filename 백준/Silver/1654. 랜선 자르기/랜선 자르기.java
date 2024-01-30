import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[k];
		for (int i = 0; i < k; i++)
			arr[i] = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		long e = arr[k - 1];
		long s = 1;
		long cnt, mid;

		while (s <= e) {
			cnt = 0;
			mid = (s + e) / 2;

			for (int i = 0; i < k; i++)
				cnt += arr[i] / mid;

			if (cnt < n)
				e = mid - 1;
			else
				s = mid + 1;
		}

		System.out.println(e);
	}
}