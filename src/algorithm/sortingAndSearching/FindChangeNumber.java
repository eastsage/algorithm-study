package algorithm.sortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class FindChangeNumber {
    public static String solution(int size, int[] arr) {
        StringBuilder answer = new StringBuilder();
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        for (int i = 0; i < size; i++) {
            if (arr[i] != sortedArr[i]) {
                answer.append((i + 1) + " ");
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, arr));
    }
}
