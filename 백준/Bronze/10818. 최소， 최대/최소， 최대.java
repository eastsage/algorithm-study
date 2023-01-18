import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int arr[] = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = sc.nextInt();
        }
        int min = arr[0];
        int max = arr[0];

        for (int j = 0; j < a; j++) {
            if (min >= arr[j])
                min = arr[j];
            if (max <= arr[j])
                max = arr[j];
        }
        System.out.println(min + " " + max);


    }
}
