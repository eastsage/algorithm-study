import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        result = new int[7];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        combi(0, 0);
    }

    static void combi(int cnt, int start) {
        if (cnt == 7) {
            int sum = 0;
            for (int i : result) {
                sum += i;
            }
            if (sum == 100) {
                for (int i : result) {
                    System.out.println(i);
                }
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            result[cnt] = arr[i];
            combi(cnt + 1, i + 1);
        }
    }
}