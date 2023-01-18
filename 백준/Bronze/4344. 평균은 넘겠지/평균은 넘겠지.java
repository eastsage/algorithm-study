import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int student = sc.nextInt();
            int sum = 0;
            int count = 0;
            float avg = 0;
            double result = 0;
            int arr[] = new int[student];

            for (int j = 0; j < student; j++) {
                arr[j] = sc.nextInt();
                sum += arr[j];
            }
            avg = (float)sum / student;
            for (int k = 0; k < student; k++) {
                if (arr[k] > avg)
                    count++;
            }
            result = ((double)count / student) * 100.000;
            System.out.printf("%.3f", result);
            System.out.println("%");

        }

    }
}
