import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static int n;
    static boolean[] isPrime;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        List<Integer> list = new ArrayList<>();

        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                list.add(i);

                int k = 1;
                while (i * ++k <= n) {
                    isPrime[i * k] = false;
                }
            }
        }

        list.add(0);
        int s = 0, e = 0;
        long sum = list.get(0);
        long cnt = 0;

        while (s <= e && e < list.size() - 1) {
            if (sum < n) {
                sum += list.get(++e);
            } else if (sum > n) {
                sum -= list.get(s++);
            } else {
                cnt++;
                sum += list.get(++e);
                sum -= list.get(s++);
            }
        }

        System.out.println(cnt);
    }
}