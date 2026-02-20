import java.util.*;

class Solution {
    private int N;
    private int number;
    private Map<Integer, Set<Integer>> memo = new HashMap<>();

    public int solution(int iN, int iNumber) {
        this.N = iN;
        this.number = iNumber;

        if (N == number) return 1;

        // 1개부터 8개까지 탑다운으로 계산
        for (int cnt = 1; cnt <= 8; cnt++) {
            Set<Integer> candidates = recur(cnt);
            if (candidates.contains(number)) {
                return cnt;
            }
        }
        return -1;
    }

    // recur(cnt): N을 cnt번 사용해서 만들 수 있는 모든 값
    private Set<Integer> recur(int cnt) {
        if (memo.containsKey(cnt)) {
            return memo.get(cnt);
        }

        Set<Integer> result = new HashSet<>();

        // 1) 이어붙인 수 추가 (5, 55, 555 ...)
        int repeated = 0;
        for (int i = 0; i < cnt; i++) {
            repeated = repeated * 10 + N;
        }
        result.add(repeated);

        // 2) cnt를 (left + right)로 분할해서 조합
        for (int left = 1; left < cnt; left++) {
            int right = cnt - left;

            Set<Integer> leftSet = recur(left);
            Set<Integer> rightSet = recur(right);

            for (int a : leftSet) {
                for (int b : rightSet) {
                    result.add(a + b);
                    result.add(a - b);
                    result.add(a * b);
                    if (b != 0) {
                        result.add(a / b); // 정수 나눗셈
                    }
                }
            }
        }

        memo.put(cnt, result);
        return result;
    }
}