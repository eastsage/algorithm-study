import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int h, w;
	static int[] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new int[w];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		long sum = 0;
		for (int i = 1; i < map.length - 1; i++) {
			int lPeek = 0;
			int rPeek = 0;

			for (int j = i - 1; j >= 0; j--) {
				lPeek = Math.max(lPeek, map[j]);
			}

			for (int j = i + 1; j < map.length; j++) {
				rPeek = Math.max(rPeek, map[j]);
			}

			if (map[i] < lPeek && map[i] < rPeek) {
				sum += Math.min(lPeek, rPeek) - map[i]; // 더 낮은 봉우리 만큼 물이 고임
			}
		}
		System.out.println(sum);
	}
}