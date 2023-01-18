import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(d(sc.nextInt()));
    }

    public static int d(int num) {
        int cnt = 0;

        if (num < 100) {
            return num;
        }
        else {
            cnt = 99;
            if (num == 1000) {
                num = 999;
            }

            for (int i = 100; i <= num; i++) {
                int hund = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;

                if ((hund - ten) == (ten - one)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}