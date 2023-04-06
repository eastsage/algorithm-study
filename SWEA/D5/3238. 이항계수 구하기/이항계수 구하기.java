import java.util.Scanner;

public class Solution {
    static final int MAX_N = 100002;
    static long[] fact = new long[MAX_N];
    static long ans, X, Y, n, r, p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; ++tc) {
            n = sc.nextLong();
            r = sc.nextLong();
            p = sc.nextLong();

            fact[0] = 1;
            for (int i = 1; i <= p; ++i) {
                fact[i] = (i * fact[i - 1]) % p;
            }

            ans = 1;

            // 뤼카의 정리
            while (r != 0 || n != 0) {
                X = n % p;
                Y = r % p;

                if (Y > X) {
                    ans = 0;
                    break;
                }

                // 페르마의 소정리
                ans = (ans * fact[(int) X]) % p;
                for (int i = 0; i < p - 2; i++) {
                    ans = (ans * fact[(int) (X - Y)] * fact[(int) Y]) % p;
                }
                n /= p;
                r /= p;
            }
            ans %= p;
            System.out.printf("#%d %d\n", tc, ans);
        }
        sc.close();
    }
}