import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static int n, m, t;
    static long totalCnt;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            totalCnt = 0;
//            combi(0, 0);
            //mCn = m*....(m-n+1)/n!
            BigInteger numerator = new BigInteger("1");
            BigInteger denominator = new BigInteger("1");
            for (int j = m - n + 1; j <= m; j++) {
                numerator = numerator.multiply(BigInteger.valueOf(j));
            }
            for (int j = 1; j <= n; j++) {
                denominator = denominator.multiply(BigInteger.valueOf(j));
            }
            BigInteger result = numerator.divide(denominator);
            System.out.println(result);
        }
    }

    static void combi(int cnt, int start) {
        if (cnt == n) {
            totalCnt++;
            return;
        }

        for (int i = start; i < m; i++) {
            combi(cnt + 1, i + 1);
        }
    }
}