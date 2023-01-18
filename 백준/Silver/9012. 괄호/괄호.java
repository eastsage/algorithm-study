import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            char[] chars = s.toCharArray();
            int count = 0;
            for (char c : chars) {
                if (c == '(') {
                    count++;
                } else {
                    count--;
                }
                if (count < 0) {
                    break;
                }
            }
            if (count == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}