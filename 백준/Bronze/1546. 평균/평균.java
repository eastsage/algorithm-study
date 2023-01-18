
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        double sum = 0;
        double result = 0;
        double arr[] = new double[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] / max) * 100.000;
            sum += arr[i];
        }

        result = sum/arr.length;
        System.out.println(result);


    }
}
