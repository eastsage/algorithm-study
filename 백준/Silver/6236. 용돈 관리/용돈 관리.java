import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final long INF = Long.MAX_VALUE / 2;
    static int n, m, s, e;
    static int[] arr;
    static int[][] map;
    static boolean[] visible;
    static List<long[]>[] edges;

    public static void main(String[] args) throws IOException {
        init();

        while (s < e) {
            int mid = (s + e) / 2;
            int cnt = 0;
            int money = 0;
            for (int i = 1; i <= n; i++) {
                if (money < arr[i]) {
                    cnt++;
                    money = mid - arr[i];
                } else {
                    money -= arr[i];
                }
            }

            if (cnt > m) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(s);
    }


    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        s = 0;
        e = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            e += arr[i];
            s = Math.max(s, arr[i]);
        }

    }
}