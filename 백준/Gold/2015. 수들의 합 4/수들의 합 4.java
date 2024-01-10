import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long k = Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Map<Long, Long> map = new HashMap<>();
		map.put(0l, 1l);
		long[] arr = new long[n + 1];
		long cnt = 0;

		for (int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(st.nextToken()) + arr[i - 1];
			cnt += map.getOrDefault(arr[i] - k, 0l);
			map.put(arr[i], map.getOrDefault(arr[i], 0l) + 1);
		}


		System.out.println(cnt);
		
	}
}