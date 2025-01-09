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
        int p1 = 0, p2 = 1;
        pSum = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            pSum[i] = Long.parseLong(st.nextToken()) + pSum[i - 1];
        }
        int res = Integer.MAX_VALUE;
        while (p2 <= n) {
            if (pSum[p2] - pSum[p1] >= m) {
                res = Math.min(res, p2 - p1);
            }

            if (pSum[p2] - pSum[p1] < m) {
                p2++;
            } else {
                p1++;
            }
        }
        if (res == Integer.MAX_VALUE) res = 0;
        System.out.println(res);
    }
}