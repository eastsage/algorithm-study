import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] a, b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[Integer.parseInt(st.nextToken())];
        b = new int[Integer.parseInt(st.nextToken())];

        int[] c = new int[a.length + b.length];
        int i = -1;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            c[++i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            c[++i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder();
        for (int num : c) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}