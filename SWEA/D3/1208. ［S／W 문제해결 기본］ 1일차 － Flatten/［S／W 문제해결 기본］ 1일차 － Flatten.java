import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 0; testCase < 10; testCase++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.print("#" + (testCase + 1) + " ");
            narasi(arr, n);
        }
    }

    static void narasi(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 0; i < 100; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIdx = i;
            }
            if (min > arr[i]) {
                min = arr[i];
                minIdx = i;
            }
        }
        int diff = max - min;
        if (n == 0 || diff <= 1) {
            System.out.println(diff);
            return;
        }
        arr[maxIdx] -= 1;
        arr[minIdx] += 1;
        narasi(arr, n - 1);
    }
}