import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        String str = String.valueOf(a * b * c);
        String[] strArr = str.split("");
        int arr[] = new int[10];

        for (int i = 0; i < str.length(); i++) {
            int d = Integer.parseInt(strArr[i]);
            arr[d]++;
        }
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }

    }
}
