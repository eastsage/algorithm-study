import java.util.*;

public class Main {

    public static void main(String[] args) {

        boolean check[] = new boolean[10001];

        for (int i = 0; i < 10001; i++) {
            int selfnum = d(i);
            if (selfnum < 10001)
                check[selfnum] = true;
        }

        for (int i = 0; i < 10001; i++) {
            if (check[i] == false)
                System.out.println(i);
        }
    }

    public static int d(int number) {
        int sum = number;
        while (number != 0) {
            sum += number%10;
            number /= 10;
        }
        return sum;
    }
}