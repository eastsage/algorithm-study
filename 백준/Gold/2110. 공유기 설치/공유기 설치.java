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
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		arr = new int[n];

		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);


		int s = 1;
		int e = arr[n - 1] - arr[0] + 1;

		while(s < e) {
			int mid = (e + s) >>> 1;
			if(canInstall(mid) < k) {
				e = mid;
			}
			else {
				s = mid + 1;
			}
		}
		System.out.println(s - 1);
	}

	public static int canInstall(int dist) {

		int cnt = 1;
		int lastLocate = arr[0];

		for(int i = 1; i < arr.length; i++) {
			int locate = arr[i];

			if(locate - lastLocate >= dist) {
				cnt++;
				lastLocate = locate;
			}
		}
		return cnt;

	}
}