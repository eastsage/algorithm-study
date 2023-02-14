import java.util.Scanner;

public class Solution {
    static int min;
    static int N;
    static int M;
    static int[] arr;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int i = 1; i <= TC; i++) {
            min = Integer.MAX_VALUE;
            N = sc.nextInt();
            M = sc.nextInt();
            arr = new int[N];
            result = new int[2];
            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }
            combi(0, 0);
            if (min == Integer.MAX_VALUE) {
                System.out.println("#" + i + " " + (-1));
            } else {
                System.out.println("#" + i + " " + (M - min));
            }
        }

    }

    static void combi(int cnt, int start) {
        if (cnt == 2) {
            int sum = 0;
            for (int i : result) {
                sum += i;
            }
            if (sum > M) {
                return;
            }
            min = Math.min(min, (M - sum));
            return;
        }
        for (int i = start; i < N; i++) {
            result[cnt] = arr[i];
            combi(cnt + 1, i + 1);
        }
    }
}