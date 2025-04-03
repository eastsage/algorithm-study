import java.util.*;
class Solution {
    int m, n;
    int[][] map, dp;
    int[] dx, dy;
    public int solution(int a, int b, int[][] puddles) {
        int answer = 0;
        m=a;
        n=b;
        map = new int[m+1][n+1];
        dx = new int[]{0, 1};
        dy = new int[]{1, 0};
        
        for(int[] dot : puddles) {
            map[dot[0]-1][dot[1]-1] = 1;
        }
        
        dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++) {
            Arrays.fill(dp[i], -1);
        }
        answer = recur(0,0);
        // for(int i=0; i<=m; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        
        return answer;
    }
    int recur(int x, int y) {
        if(x==m-1 && y==n-1) {
            return 1;
        }
        if(dp[x][y] != -1) {
            return dp[x][y];
        }
        int tmp = 0;
        for(int i=0; i<2; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=m || ny>=n) continue;
            if(map[nx][ny] == 1) continue;
            tmp += recur(nx, ny);
        }
        return dp[x][y] = tmp % 1000000007;
    }
}