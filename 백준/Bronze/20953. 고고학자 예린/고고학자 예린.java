import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = 0;
        int b = 0;
        int fac;

        for (int i = 0; i < n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            fac = 0;
            int c = a + b;
            for (int j = 0; j < a + b; j++) {
                for (int k = 0; k < j; k++) {
                    fac++;
                }
            }
            System.out.println(fac * c);

        }

    }
}
