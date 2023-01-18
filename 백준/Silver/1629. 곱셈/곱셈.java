import java.util.*;

public class Main {

    public static long c;
    public static void main(String[] args) {

//        첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.

        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        c = sc.nextLong();

        System.out.println(pow(a, b));

    }
    public static long pow(long a, long exponent) {
        if (exponent == 1)
            return a % c;

        long temp = pow(a, exponent / 2);
        if (exponent % 2 == 1) {
            return (temp * temp % c) * a % c;
        }

        return temp * temp % c;
    }
}