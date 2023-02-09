import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int max = 0;
            for (int i = 0; i <= n - m; i++) {
                for (int j = 0; j <= n - m; j++) {
                    int temp = flySwatter(arr, m, i, j);
                    if (temp >= max) {
                        max = temp;
                    }
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }

    static int flySwatter(int[][] arr, int m, int x, int y) {
        int sum = 0;
        for (int i = x; i < x + m; i++) {
            for (int j = y; j < y + m; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}