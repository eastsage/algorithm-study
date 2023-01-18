import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num = sc.nextInt();
        int a = 1;

        while (num >= 10) {
            a = a * 10;
            num = Math.round(num / 10);
        }
        System.out.println((int)(num * a));
    }
}
