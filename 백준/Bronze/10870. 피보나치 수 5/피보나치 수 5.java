import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int arr[] = new int[a+1];
        if (a==0)
            arr[0] = 0;
        if (a>=1) {
            arr[0] = 0;
            arr[1] = 1;
        }

        if (a > 1) {
            for (int i = 2; i < a+1; i++) {
                arr[i] = arr[i-1] + arr[i-2];
            }
        }

        System.out.println(arr[a]);
    }
}