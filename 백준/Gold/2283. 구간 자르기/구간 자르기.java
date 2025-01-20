import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 처리
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 구간 개수
        long k = Long.parseLong(st.nextToken()); // 목표 길이

        int[] imos = new int[1_000_002]; // IMOS 배열 (범위 초과 방지)

        // 각 구간 입력 및 IMOS 배열 갱신
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 구간 시작
            int e = Integer.parseInt(st.nextToken()); // 구간 끝
            imos[s]++;        // 구간 시작점
            imos[e]--;    // 구간 끝 다음 지점
        }

        // 누적합 배열 생성 (sum: 각 지점의 겹치는 구간 수)
        int[] sum = new int[1_000_001];
        sum[0] = imos[0];
        for (int i = 1; i <= 1_000_000; i++) {
            sum[i] = sum[i - 1] + imos[i];
        }

        // pSum 배열 생성 (0부터 i까지의 누적합)
        int[] pSum = new int[1_000_002];
        pSum[0] = 0;
        for (int i = 1; i <= 1_000_000; i++) {
            pSum[i] = pSum[i - 1] + sum[i - 1];
        }

        // 슬라이딩 윈도우로 [pSum, B] 탐색
        int s = 0;
        int e = 0;

        while (e <= 1_000_000) {
            int tmp = pSum[e] - pSum[s];
            if (tmp == k) {
                System.out.println(s + " " + e);
                return;
            } else if (tmp < k) {
                e++;
            } else {
                s++;
            }
        }

        // 조건을 만족하는 구간이 없는 경우
        System.out.println("0 0");
    }
}