package algorithm.sortingAndSearching;

import java.io.IOException;
import java.util.Scanner;

public class LeastRecentlyUsed {
    public static int[] solution(int size, int[] operations) {
        int hitIndex = 0;
        int[] cache = new int[size];
        for (int operation : operations) {
            hitIndex = -1;
            for (int i = 0; i < size; i++) {
                if (cache[i] == operation) {
                    hitIndex = i;
                }
            }
            if (hitIndex == -1) {
                for (int i = size - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for (int i = hitIndex; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = operation;
        }

        return cache;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i : solution(s, arr)) {
            System.out.print(i + " ");
        }
    }
}
