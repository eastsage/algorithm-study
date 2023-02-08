import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[m];
        Combination(0, 1);

    }

    static void Combination(int cnt, int start) {
        if (cnt == m) {
            System.out.println(toString(result));
            return;
        }
        for (int i = start; i <= n; i++) {
            result[cnt] = i;
            Combination(cnt + 1, i + 1);
        }
    }

    static String toString(int[] a) {
        int iMax = a.length - 1;
        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax) {
                return b.toString();
            }
            b.append(" ");
        }
    }
}