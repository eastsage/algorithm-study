import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[7];
        int sum = 0;
        int a = 10000;

        for (int i = 0; i < 7; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 7; i++) {
            if ((arr[i] % 2) == 1) {
                sum = sum + arr[i];
                if (a > arr[i]) {
                    a = arr[i];
                }
            }
        }

        if (sum == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(a);
    }
}
