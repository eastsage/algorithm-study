import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int[][] map;
    static Stack<Character> result = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = " " + sc.next();
        String s2 = " " + sc.next();
        int l1 = s1.length();
        int l2 = s2.length();
        map = new int[l2][l1];

        for (int i = 1; i < l2; i++) {
            for (int j = 1; j < l1; j++) {
                if (s1.charAt(j) == s2.charAt(i)) {
                    map[i][j] = map[i - 1][j - 1] + 1;
                } else {
                    map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
                }
            }
        }
        int i = l2 - 1;
        int j = l1 - 1;
        int resultSize = map[i][j];
        while (result.size() != resultSize) {
            if (j > 0 && map[i][j] == map[i][j - 1]) {
                j--;
            } else if (i > 0 && map[i][j] == map[i - 1][j]) {
                i--;
            } else {
                result.push(s1.charAt(j));
                i--;
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.append(result.pop());
        }
        System.out.println(resultSize);
        System.out.println(sb.toString());
    }
}