import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int korea;
        int math;
        int result;

        if (a % c == 0) {
            korea = a / c;
        } else {
            korea = a / c + 1;
        }

        if (b % d == 0) {
            math = b / d;
        } else {
            math = b / d + 1;
        }

        if (korea >= math) {
            result = l - korea;
        } else {
            result = l - math;
        }

        System.out.println(result);
    }
}
