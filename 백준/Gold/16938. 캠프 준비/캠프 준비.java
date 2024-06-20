import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, l, r, x, result;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        recur(0, 0, 0, 0, Integer.MAX_VALUE);
        System.out.println(result);
    }
    static void recur(int cur, int total, int cnt, int max, int min) {
        if (cur == n) {
            if (cnt < 2 || (max - min) < x || total < l || total > r) return;
            result++;
            return;
        }
        recur(cur + 1, total + arr[cur], cnt + 1, Math.max(max, arr[cur]), Math.min(min, arr[cur]));
        recur(cur + 1, total, cnt, max, min);
    }
}