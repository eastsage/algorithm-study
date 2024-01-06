import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] prime = new boolean[1001];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        int max = (int) Math.sqrt(1000);
        for (int i = 2; i <= max; i++) {
            if (prime[i]) {
                int num = 1;
                while (i * ++num <= 1000) {
                    prime[i * num] = false;
                }
            }
        }

        for (int i : arr) {
            if (prime[i]) {
                result++;
            }
        }
        System.out.println(result);
    }
}