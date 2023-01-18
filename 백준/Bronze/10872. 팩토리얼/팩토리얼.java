import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int result = 1;
        for (int i = 1; i < a+1; i++) {
            result = result * i;
        }
        if (a==0)
            result = 1;
        System.out.println(result);
    }
}