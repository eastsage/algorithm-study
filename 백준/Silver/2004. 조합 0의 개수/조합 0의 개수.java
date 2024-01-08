import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());



        long n2Cnt = getCnt(n, 2);
        long m2Cnt = getCnt(m, 2);
        long nm2Cnt = getCnt(n - m, 2);

        long n5Cnt = getCnt(n, 5);
        long m5Cnt = getCnt(m, 5);
        long nm5Cnt = getCnt(n - m, 5);

        long two = n2Cnt - (m2Cnt + nm2Cnt);
        long five = n5Cnt - (m5Cnt + nm5Cnt);

        long result = Math.min(two, five);
        System.out.println(result);
    }
    // 2와 5의 개수 계산 함수
    static long getCnt(long num, long div) {
        long cnt = 0;
        while (num >= div) {
            cnt += num / div;
            num /= div;
        }
        return cnt;
    }
}