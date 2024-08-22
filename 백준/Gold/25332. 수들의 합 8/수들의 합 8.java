import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr, pSumA, pSumB;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        pSumA = new int[n + 1];
        pSumB = new int[n + 1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        long result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            pSumA[i] = Integer.parseInt(st1.nextToken()) + pSumA[i - 1];
            pSumB[i] = Integer.parseInt(st2.nextToken()) + pSumB[i - 1];
            
            // 1 ~ i 까지 구간 합이 같음
            if (pSumA[i] == pSumB[i]) result++;
            
            // 이전에 같은 값이 등장했다면 그때의 인덱스 x부터 i 까지의 누적 합이 같다는 뜻
            result += map.getOrDefault(pSumA[i] - pSumB[i], 0);
            
            // 현재 값 추가
            map.put(pSumA[i] - pSumB[i], map.getOrDefault(pSumA[i] - pSumB[i], 0) + 1);
        }

        System.out.println(result);
    }
}