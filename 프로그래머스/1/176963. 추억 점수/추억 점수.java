import java.util.*;
class Solution {
    public List<Integer> solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        List<Integer> answer = new ArrayList<>();
        for(String[] names : photo) {
            int sum = 0;
            for(String str : names) {
                if(map.containsKey(str)) {
                    sum += map.get(str);
                }
            }
            answer.add(sum);
        }
        
        return answer;
    }
}