import java.util.*;
class Solution {
    public static int[] solution(int[] sequence, int k) {
        PriorityQueue<SubSeq> pq = new PriorityQueue<>();
        int lt = 0;
        int rt = 0;
        int sum = sequence[0];
        while(rt < sequence.length) {
            if (sum < k) {
                if (rt >= sequence.length - 1) break;
                rt++;
                sum += sequence[rt];
            } else if (sum > k) {
                sum -= sequence[lt];
                lt++;
            } else {
                pq.offer(new SubSeq(rt - lt, lt, rt));
                sum -= sequence[lt];
                lt++;
            }
        }
        SubSeq ss = pq.poll();
        
        int[] answer = new int[]{ss.lt, ss.rt};
        return answer;
    }
    private static class SubSeq implements Comparable<SubSeq> {
        int diff;
        int lt;
        int rt;
        
        public SubSeq (int diff, int lt, int rt) {
            this.diff = diff;
            this.lt = lt;
            this.rt = rt;
        }
        
        @Override
        public int compareTo(SubSeq o) {
            if (this.diff == o.diff) {
                return this.lt - o.lt;
            }
            return this.diff - o.diff;
        }
    }
}