import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();


        for (int i = 0; i < num; i++) {
            String s = sc.next();
            int score = 0;
            int result = 0;

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'O') {
                    score ++;
                    result += score;
                }
                else
                    score = 0;
            }
            System.out.println(result);
        }

    }
}
