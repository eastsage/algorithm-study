import java.util.*;
class Solution {
    static int[][] sq;
    static int[] answer;
    static int res;
    static int m;
    static int sn;
    public int solution(int n, int[][] q, int[] ans) {
        answer = ans;
        sq = q;
        m = q.length;
        sn = n;
        
        recur(1, 0, new HashSet<Integer>());
        return res;
    }
    void recur(int cur, int depth, Set<Integer> set) {
        if(depth == 5) {
            boolean valid = true;
            for(int i=0; i<m; i++) {
                int cnt = 0;
                for(int j=0; j<5; j++) {
                    if(set.contains(sq[i][j])) cnt++;
                }
                if(cnt != answer[i]) {
                    return;
                }
            }
            if(valid) {
                res++;
                return;
            }
        }
        if(cur > sn) return;
        
        set.add(cur);
        recur(cur+1, depth+1, set);
        set.remove(cur);
        recur(cur+1, depth, set);
    }
}