import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        int score = 0;
        for (int i : arr) {
            if (i == 0) {
                count = 0;
            }
            if (i == 1) {
                score += ++count;
            }
        }
        System.out.println(score);
    }
}
