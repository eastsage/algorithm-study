import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long result;
    static boolean[] isPrimes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt((st.nextToken()));
        int sqrtn = (int) (Math.sqrt(n) + 0.0000001);
        long sum = 0;

        for (int i = 2; i <= sqrtn; i++) {
            int k = n / i;
            sum += i * (k - i + 1) + (long) (k - i) * (k + i + 1) / 2;
            sum %= 1_000_000;
        }

        System.out.println(sum);
    }
}