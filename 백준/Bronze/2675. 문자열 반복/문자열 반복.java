import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        Vector<Character> ch = new Vector<Character>();

        for (int p = 0; p < b; p++) {
            int a = sc.nextInt();
            String ss = sc.next();
            ch.removeAllElements();

            for (int i = 0; i < ss.length(); i++) {
                for (int j = 0; j < a; j++) {
                    ch.add(ss.charAt(i));
                }
            }
            for (char s : ch)
                System.out.print(s);
            System.out.println();
        }

    }
}
