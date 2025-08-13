import java.util.*;
class Solution {
    static int[] arr;
    static int t, n, res;
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        arr = numbers;
        t = target;
        n = arr.length;
        recur(0, 0);
        return res;
    }
    static void recur(int cur, int depth) {
        if(depth == n) {
            if(cur == t) res++;
            return;
        }
        recur(cur + arr[depth], depth + 1);
        recur(cur - arr[depth], depth + 1);
    }
}