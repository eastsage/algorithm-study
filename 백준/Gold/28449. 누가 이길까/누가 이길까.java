import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] hi, arc;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        hi = new int[n];
        arc = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hi[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arc[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(hi);
        Arrays.sort(arc);

        long win = 0L;
        long draw = 0L;
        long lose = 0L;
        long cnt = 0L;
        long idx = 0L;
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < hi.length; i++) {
            int num = hi[i];
            if (temp == num) {
                win += idx;
                draw += cnt;
                continue;
            }
            temp = num;
            idx = Arrays.binarySearch(arc, num);
            for (int j = 0; j <= (int) idx; j++) {
                if (arc[j] == arc[(int) idx]) {
                    idx = j;
                    break;
                }
            }
            if (idx < 0) idx = -(idx + 1);

            win += idx;
            cnt = 0L;
            for (long j = idx; j < arc.length; j++) {
                if (hi[i] == arc[(int) j]) {
                    draw++;
                    cnt++;
                } else break;

            }
        }

        lose = (long) n * m - win - draw;
        System.out.println(win + " " + lose + " " + draw);
    }
}