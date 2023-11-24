import java.util.*;
class Solution {
    /**
    1 ~ 32,000    
    1
    2 - 11
    3 - 21 12
    4 - 31 13 22
    5 - 14 41 23 32
    6 - 15 51 24 42 33
    ...
    **/
    public int solution(int n, int number) {
        Set[] sets = new Set[9];
        for(int i=1; i<9; i++) {
            sets[i] = new HashSet<Integer>();
        }
        sets[1].add(n);
        
        for(int i=2; i<9; i++) {
            for(int j=1; j<i; j++) {
                Set<Integer> pre = sets[j];
                Set<Integer> post = sets[i-j];
                
                for(Integer preNum : pre) {
                    for(Integer postNum : post) {
                        sets[i].add(preNum + postNum);
                        sets[i].add(preNum - postNum);
                        sets[i].add(preNum * postNum);
                        if(postNum != 0 && preNum != 0) {
                            sets[i].add(preNum / postNum);
                        }
                    }
                }
            }
            sets[i].add(Integer.parseInt(String.valueOf(n).repeat(i)));
        }
        for(int i=1; i<9; i++) {
            Set<Integer> set = sets[i];
            for(Integer num : set) {
                if(num == number) {
                    return i;
                }
            }
        }
        
        return -1;
    }
}