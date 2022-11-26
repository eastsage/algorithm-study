package algorithm.sortingAndSearching;

import java.util.Scanner;

public class SelectionSort {
    public static int[] solution(int size, int[] arr) {
        for (int i = 0; i < size; i++) {
            int min = Integer.MAX_VALUE;
            int pos = 0;
            for (int j = i; j < size; j++) {
                if (arr[j] < min) {
                    pos = j;
                    min = arr[j];
                }
            }
            arr[pos] = arr[i];
            arr[i] = min;
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
