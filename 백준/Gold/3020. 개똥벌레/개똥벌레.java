import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, h;
    static long[] imos;
    static long[] prefixSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        imos = new long[h + 1];
        prefixSum = new long[h + 1];

        for (long i = 1; i <= n; i++) {
            int bar = Integer.parseInt(br.readLine());
            if (i % 2 == 1) {
                imos[1]++;
                imos[bar + 1]--;
            } else {
                imos[h - bar + 1]++;
            }
        }
        long min = Integer.MAX_VALUE;
        for (int i = 1; i <= h; i++) {
            prefixSum[i] = prefixSum[i - 1] + imos[i];
            min = Math.min(min, prefixSum[i]);
        }
        long cnt = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            if (prefixSum[i] == min) {
                cnt++;
            }
        }
        System.out.println(min + " " + cnt);

    }
}