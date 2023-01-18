import java.util.*;

public class Main {

    static boolean check(String s) {
        boolean check[] = new boolean[26];
        int prev = 0;

        for (int i = 0; i < s.length(); i++) {
            int now = s.charAt(i);

            if (prev != now) {
                if (check[now - 'a'] == false) {
                    check[now - 'a'] = true;
                    prev = now;
                }

                else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (check(s) == true)
                count++;
        }
        System.out.println(count);
    }
}
