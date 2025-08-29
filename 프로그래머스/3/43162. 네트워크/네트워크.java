import java.util.*;
class Solution {
    static boolean[] visited;
    static Queue<Integer> q;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        q = new ArrayDeque<Integer>();
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                q.offer(i);
                answer++;
            }
            
            while(!q.isEmpty()) {
                int cur = q.poll();
                for(int j=0; j<n; j++) {
                    if(visited[j]) continue;
                    if(computers[cur][j] == 0) continue;
                    visited[j] = true;
                    q.offer(j);
                }
            }
        }
        
        return answer;
    }
}