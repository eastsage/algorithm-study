import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int max = 0;
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		Arrays.sort(arr);
		long result = parametricSearch(max);
		System.out.println(result);
	}

	static long parametricSearch(int max) {
		int low = 0;
		int high = max;
		int result = 0;
		while (low <= high) {

			int mid = (low + high) >>> 1;

			if (check(mid)) {
				low = mid + 1;
				result = mid;
			} else {
				high = mid - 1;
			}
		}
		return result;
	}

	static boolean check(int height) {
		long sum = 0;
		for (int h : arr) {
			int cur = h - height;
			if (cur > 0) {
				sum += cur;
			}
		}
		if (sum >= m)
			return true;
		return false;
	}

}