import java.util.*;
import java.io.*;
class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, 190_000_000);
        dp[y] = 0; // Base case: if the destination is y, steps required are 0
        
        // Bottom-up approach: start from y and go towards x
        for (int i = y; i >= x; i--) {
            if (i % 2 == 0 && i / 2 >= x) {
                dp[i / 2] = Math.min(dp[i / 2], dp[i] + 1);
            }
            if (i % 3 == 0 && i / 3 >= x) {
                dp[i / 3] = Math.min(dp[i / 3], dp[i] + 1);
            }
            if (i - n >= x) {
                dp[i - n] = Math.min(dp[i - n], dp[i] + 1);
            }
        }
        
        int answer = dp[x];
        if (answer == 190_000_000) answer = -1;
        return answer;
    }
}