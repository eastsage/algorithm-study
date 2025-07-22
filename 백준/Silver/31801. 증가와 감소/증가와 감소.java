import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1_000_000;
    static boolean[] isUpDown = new boolean[MAX + 1];
    static int[] prefix = new int[MAX + 1];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1) 전처리: 1 ~ MAX까지 증가후감소수 판별 및 누적합
        for (int i = 1; i <= MAX; i++) {
            isUpDown[i] = isUpDownNumber(i);
            prefix[i] = prefix[i - 1] + (isUpDown[i] ? 1 : 0);
        }

        // 2) 쿼리 처리
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 범위 보정
            a = Math.max(a, 1);
            b = Math.min(b, MAX);
            if (a > b) {
                sb.append(0).append('\n');
            } else {
                sb.append(prefix[b] - prefix[a - 1]).append('\n');
            }
        }

        // 결과 출력
        System.out.print(sb.toString());
    }

    // n이 "증가 후 감소" 형태인지 판별
    private static boolean isUpDownNumber(int n) {
        String s = Integer.toString(n);
        int len = s.length();
        if (len < 3) return false;  // 최소 3자리 이상이어야 함

        // 1) 엄격히 증가하다가 멈추는 지점 찾기
        int peak = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) > s.charAt(i - 1)) {
                peak = i;
            } else {
                break;
            }
        }
        // peak는 1 이상(len-2 이하)이어야 함
        if (peak < 1 || peak > len - 2) return false;

        // 2) peak 이후로는 엄격히 감소만 하는지 확인
        for (int i = peak + 1; i < len; i++) {
            if (s.charAt(i) >= s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
