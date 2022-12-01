package algorithm.sortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static int solution(int target, int[] arr) {
        Arrays.sort(arr);
        int startIndex = 0;
        int lastIndex = arr.length - 1;
        while (true) {
            int middleIndex = (lastIndex + startIndex) / 2;
            if (arr[middleIndex] == target) {
                return middleIndex + 1;
            }
            if (arr[middleIndex] > target) {
                lastIndex = middleIndex - 1;
            }
            if (arr[middleIndex] < target) {
                startIndex = middleIndex + 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(m, arr));
    }
}
