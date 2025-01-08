import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int n, k;
    static long[] pSum1, pSum2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        pSum1 = new long[n + 1];
        pSum2 = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            pSum1[i] = Long.parseLong(st.nextToken()) + pSum1[i - 1];
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            pSum2[i] = Long.parseLong(st.nextToken()) + pSum2[i - 1];
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            //i == 가방1에서 뺀 수 & k-i == 가방2에서 뺀 수
            int k1 = n - i;
            int k2 = n - (k - i);
            if (k1 < 0) k1 = 0;
            if (k2 < 0) k2 = 0;
            long bag1 = pSum1[k1];
            long bag2 = pSum2[k2];
            res = Math.min(res, Math.max(bag1, bag2));
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}