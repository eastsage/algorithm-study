import java.util.*;
class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] map;
    static boolean[][] visited;
    static int n,m,res;
    public static int solution(int[][] tmp) {
        res = Integer.MAX_VALUE;
        map = tmp;
        n = tmp.length;
        m = tmp[0].length;
        visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0,0,1});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0||nx>=n||ny<0||ny>=m) continue;
                if(visited[nx][ny] || map[nx][ny]==0) continue;
                if(nx==n-1 && ny ==m-1) {
                    return cur[2]+1;
                }
                visited[nx][ny] = true;
                q.offer(new int[] {nx, ny, cur[2]+1});
            }
        }
        return -1;
    }
}