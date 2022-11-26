package algorithm.sortingAndSearching;

import java.util.Scanner;

public class BubbleSort {
    public static int[] solution(int size, int[] arr) {
        int temp = 0;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = arr[i];
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] solution = solution(n, arr);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
