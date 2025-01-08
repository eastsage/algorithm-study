import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int n, m, k;
    static long[] pSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pSum = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            pSum[i] = Long.parseLong(st.nextToken()) + pSum[i - 1];
        }
        long max = 0;
        for (int i = m; i <= n; i++) {
            max = Math.max(max, pSum[i] - pSum[i - m]);
        }
        System.out.println(max);
    }
}
// 0 10 30 60 80 90