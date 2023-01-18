import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b;
        int c = a;
        int i = 0;
        while (true) {
            b = (a/10) + (a%10);
            if ( b >= 10)
                b %= 10;
            a = (a%10)*10 + b;
            i++;
            if ( c == a) {
                System.out.println(i);
                break;
            }
        }
    }
}
