import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, result;
    static int[] arr, pSum, lCnt, rCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String s = br.readLine();
        pSum = new int[s.length() + 1];
        lCnt = new int[s.length() + 1];
        rCnt = new int[s.length() + 1];
        List<Integer> negatives = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '(') {
                pSum[i] = pSum[i - 1] + 1;
                lCnt[i] = lCnt[i - 1] + 1;
                rCnt[i] = rCnt[i - 1];
            } else {
                pSum[i] = pSum[i - 1] - 1;
                lCnt[i] = lCnt[i - 1];
                rCnt[i] = rCnt[i - 1] + 1;
            }
            if (pSum[i] < 0) negatives.add(i);
        }

        /**
         * 누적합이 -2 일 때 처음으로 음수가 된 idx를 찾고 0~idx 까지 ')'의 갯수
         * 누적합이 2 일 때 누적합 배열의 역순으로 2 이상인 범위에서 '('의 갯수
         */
        if (pSum[s.length()] == -2) {
            int minNegativePoint = negatives.get(0);
            result = rCnt[minNegativePoint];
        } else {
            int idx = 0;
            for (int i = s.length(); i >= 1; i--) {
                if (pSum[i] < 2) {
                    idx = i;
                    break;
                }
            }
            result = lCnt[s.length()] - lCnt[idx];
        }
//        System.out.println(Arrays.toString(pSum));
//        System.out.println(Arrays.toString(rCnt));
//        System.out.println(Arrays.toString(lCnt));
        System.out.println(result);
    }
}