import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static long k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Long.parseLong(br.readLine());
        long max = (long) Math.sqrt(k);
        List<Long> result = new ArrayList<>();
        long i = 1;
        while (++i <= k && i <= max) {
            while (k % i == 0) {
                result.add(i);
                k /= i;
            }
        }

        if (k != 1) {
            result.add(k);
        }
        StringBuilder sb = new StringBuilder();
        for (Long num : result) {
            sb.append(num + " ");
        }
        System.out.println(result.size());
        System.out.println(sb);
    }
}