import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[k];
        int idx = 0;
        for (int i = 0; i < k; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0 && idx > 0) {
                arr[--idx] = 0;
            } else {
                arr[idx++] = a;
            }
        }
        int sum = 0;
        if (idx == k) {
            idx--;
        }
        for (int i = 0; i <= idx; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}