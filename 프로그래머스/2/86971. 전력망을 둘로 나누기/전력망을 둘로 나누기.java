import java.util.*;
class Solution {
    static List<Integer>[] edges;
    static int n, res;
    public int solution(int a, int[][] wires) {
        res = Integer.MAX_VALUE;
        n = a;
        edges = new List[n+1];
        for(int i=1; i<=n; i++) {
            edges[i] = new ArrayList<>();
        }
        for(int[] arr : wires) {
            edges[arr[0]].add(arr[1]);
            edges[arr[1]].add(arr[0]);
        }
        
        for(int[] arr : wires) {
            int s = arr[0];
            int e = arr[1];
            edges[s].remove(Integer.valueOf(e));
            edges[e].remove(Integer.valueOf(s));
            int cnt1 = bfs(s);
            int cnt2 = bfs(e);
            res = Math.min(res, Math.abs(cnt1-cnt2));
            edges[s].add(e);
            edges[e].add(s);
            
        }
        
        return res;
    }
    static int bfs(int s) {
        int cnt = 1;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        q.offer(s);
        visited[s] = true;
        while(!q.isEmpty()) {
            cnt++;
            int cur = q.poll();
            for(Integer i : edges[cur]) {
                if(visited[i]) continue;
                q.offer(i);
                visited[i] = true;
            }
        }
        return cnt;
    }
}