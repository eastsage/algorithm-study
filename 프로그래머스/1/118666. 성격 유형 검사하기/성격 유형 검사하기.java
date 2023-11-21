import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        String[] type = {"RT", "TR", "CF", "FC", "JM", "MJ", "AN", "NA"};
        int[] score = {0,3,2,1,0,-1,-2,-3};
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String s : type) {
            map.put(s,0);
        }
        
        for(int i=0; i<survey.length; i++) {
            map.put(survey[i], map.getOrDefault(survey[i], 0) + score[choices[i]]);
        }
        for(int i=0; i<type.length; i+=2) {
            if(map.get(type[i]) >= map.get(type[i+1])) {
                answer.append(type[i].substring(0,1));
            } else {
                answer.append(type[i].substring(1));
            }
        }
        return answer.toString();
    }
}