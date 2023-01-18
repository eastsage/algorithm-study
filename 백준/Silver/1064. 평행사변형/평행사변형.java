import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] A = new int[2];
        A[0] = sc.nextInt();
        A[1] = sc.nextInt();

        int[] B = new int[2];
        B[0] = sc.nextInt();
        B[1] = sc.nextInt();

        int[] C = new int[2];
        C[0] = sc.nextInt();
        C[1] = sc.nextInt();


        double a = Math.hypot(B[0] - C[0], B[1] - C[1]);
        double b = Math.hypot(C[0] - A[0], C[1] - A[1]);
        double c = Math.hypot(A[0] - B[0], A[1] - B[1]);

        double answer;

        if ((B[0] - A[0]) * (C[1] - A[1]) == (B[1] - A[1]) * (C[0] - A[0])) {
            answer = -1;
        } else {
            double ab = 2*a+2*b;
            double bc = 2*b+2*c;
            double ca = 2*c+2*a;
            answer = Math.max(Math.max(ab, bc), ca) - Math.min(Math.min(ab, bc), ca);
        }

        System.out.println(answer);
    }
}