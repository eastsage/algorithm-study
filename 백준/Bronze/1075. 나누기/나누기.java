import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        a = a / 100 * 100;
        int c = a % b;

        if (c == 0) {
            System.out.println("00");
        } else if (b - c >= 10) {
            System.out.println(b - c);
        } else {
            System.out.println(String.format("0%d", (b - c)));
        }
    }
}
