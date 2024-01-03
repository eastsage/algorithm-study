import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * l~r까지의 합 -> (r+l)(r-l+1)/2
     * al~ar까지의 합 -> a(r-l+1) + d(l~r까지의합)
     */
    static long a, d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        a = Long.parseLong(st.nextToken());
        d = Long.parseLong(st.nextToken());
        long q = Long.parseLong(br.readLine());
        long type, l, r = 0;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            type = Long.parseLong(st.nextToken());
            l = Long.parseLong(st.nextToken());
            r = Long.parseLong(st.nextToken());

            if (type == 1) {
                sb.append(a * (r - l + 1) + d * ((r + l - 2) * (r - l + 1) / 2)).append("\n");
            } else {
                long al = a + d * (l - 1);
                if (l == r) {
                    sb.append(al).append("\n");
                } else {
                    long result = euclidean(a, d);
                    sb.append(result).append("\n");
                }
            }
        }
        System.out.print(sb);
    }

    static long euclidean(long a, long b) {
        if (b == 0) {
            return a;
        }
        return euclidean(b, a % b);
    }
}