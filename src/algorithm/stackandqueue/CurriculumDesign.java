package algorithm.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CurriculumDesign {
    public static String solution(String s1, String s2) {
        String answer = "NO";
        Queue<Character> target = new LinkedList<>();
        for (char c : s1.toCharArray()) {
            target.add(c);
        }
        for (char c : s2.toCharArray()) {
            if (target.peek() == c) {
                target.poll();
                if (target.isEmpty()) {
                    answer = "YES";
                    return answer;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        String list = sc.next();
        System.out.println(solution(target, list));
    }
}
