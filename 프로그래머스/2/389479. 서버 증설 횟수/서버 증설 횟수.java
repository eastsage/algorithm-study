import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] arr = new int[24];
        for(int i=0; i<24; i++) {
            int minServer = getMinServer(players[i], m);
            if(minServer <= arr[i]) {
                continue;
            }
            int cnt = minServer - arr[i];
            answer += cnt;
            for(int j=i; j<i+k; j++) {
                if(j > 23) break;
                arr[j] += cnt;
            }
            System.out.println(arr[i]+" "+cnt);
        }
        
        
        return answer;
    }
    
    int getMinServer(int human, int m) {
        int n = 0;
        if(human == 0) return 0;
        while(!((human >= (n*m)) && (human < (n+1) * m))) {
            n++;
        }
        return n;
    }
}