import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(br.readLine());
            char[] chars = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char c : chars) {
                if (c == '(' || c == '{' || c == '<' || c == '[') {
                    stack.push(c);
                    continue;
                }
                if (c == ')' && stack.peek() == '(') {
                    stack.pop(); continue;
                }
                if (c == '}' && stack.peek() == '{') {
                    stack.pop(); continue;
                }
                if (c == '>' && stack.peek() == '<') {
                    stack.pop(); continue;
                }
                if (c == ']' && stack.peek() == '[') {
                    stack.pop(); continue;
                }
                break;
            }
            if (stack.isEmpty()) {
                System.out.println("#" + test_case + " 1");
            } else {
                System.out.println("#" + test_case + " 0");
            }

        }

    }
}
//#1 1
//#2 0
//#3 1
//#4 1
//#5 1
//#6 0
//#7 0
//#8 1
//#9 0
//#10 1