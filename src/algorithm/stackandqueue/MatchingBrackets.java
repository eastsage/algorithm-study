package algorithm.stackandqueue;

import java.util.*;

class MatchingBrackets {
    public static String solution(String str) {
        String answer = "NO";
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(')
                stack.push(c);
            if (c == ')') {
                if (stack.isEmpty()) return answer;
                stack.pop();
            }
        }
        if (stack.isEmpty())
            answer = "YES";
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
