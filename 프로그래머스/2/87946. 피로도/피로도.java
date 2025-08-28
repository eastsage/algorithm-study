import java.util.*;
class Solution {
    static int[][] arr;
    static boolean[] visited;
    static int n;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        arr = dungeons;
        n = arr.length;
        visited = new boolean[n];
        answer = recur(k, 0);
        return answer;
    }
    int recur(int stamina, int cur) {
        if(cur == n) return 0;
        int tmp = 0;
        for(int i=0; i<n; i++) {
            if(visited[i]) continue;
            if(arr[i][0] <= stamina) {
                visited[i] = true;
                tmp = Math.max(tmp, recur(stamina - arr[i][1], cur+1) + 1);
                visited[i] = false;
            }
        }
        return tmp;
    }
}