import java.util.*;

class Solution {
    // 숫자 배열과 연산자 배열, 숫자 개수, DP 테이블 선언
    static int[] nums;
    static char[] ops;
    static int n;
    static int[][] dpMax, dpMin;

    public static int solution(String input[]) {
        // 1) 입력 문자열을 숫자와 기호로 분리
        n = (input.length + 1) / 2;                 // 숫자의 개수
        nums = new int[n];                          // 숫자 저장 배열
        ops = new char[n - 1];                      // 연산자 저장 배열
        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0) {
                // 짝수 인덱스: 숫자
                nums[i / 2] = Integer.parseInt(input[i]);
            } else {
                // 홀수 인덱스: 연산자
                ops[i / 2] = input[i].charAt(0);
            }
        }

        // 2) DP 테이블 초기화
        dpMax = new int[n][n];
        dpMin = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dpMax[i], Integer.MIN_VALUE);    // 최대값 테이블 초기값
            Arrays.fill(dpMin[i], Integer.MAX_VALUE);    // 최소값 테이블 초기값
        }

        // 3) 구간 [0..n-1] 에서 만들 수 있는 최대값 반환
        return max(0, n - 1);
    }

    /**
     * i부터 j 구간의 최대값을 재귀+메모이제이션으로 계산
     */
    static int max(int i, int j) {
        if (dpMax[i][j] != Integer.MIN_VALUE) {
            // 이미 계산済
            return dpMax[i][j];
        }
        if (i == j) {
            // 구간이 하나의 숫자만 포함할 때
            return dpMax[i][j] = nums[i];
        }

        int best = Integer.MIN_VALUE;
        // 중간 분할점을 k로 두고 왼쪽(i..k), 오른쪽(k+1..j) 구간 합침
        for (int k = i; k < j; k++) {
            char op = ops[k];
            int Lmax = max(i, k);
            int Lmin = min(i, k);
            int Rmax = max(k + 1, j);
            int Rmin = min(k + 1, j);

            if (op == '+') {
                // 더하기: 최대+최대
                best = Math.max(best, Lmax + Rmax);
            } else {
                // 뺄셈: 최대 - 최소 (왼쪽 최대, 오른쪽 최소)
                best = Math.max(best, Lmax - Rmin);
            }
        }
        return dpMax[i][j] = best;
    }

    /**
     * i부터 j 구간의 최소값을 재귀+메모이제이션으로 계산
     */
    static int min(int i, int j) {
        if (dpMin[i][j] != Integer.MAX_VALUE) {
            return dpMin[i][j];
        }
        if (i == j) {
            return dpMin[i][j] = nums[i];
        }

        int worst = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            char op = ops[k];
            int Lmax = max(i, k);
            int Lmin = min(i, k);
            int Rmax = max(k + 1, j);
            int Rmin = min(k + 1, j);

            if (op == '+') {
                // 더하기: 최소+최소
                worst = Math.min(worst, Lmin + Rmin);
            } else {
                // 뺄셈: 최소 - 최대 (왼쪽 최소, 오른쪽 최대)
                worst = Math.min(worst, Lmin - Rmax);
            }
        }
        return dpMin[i][j] = worst;
    }
}
