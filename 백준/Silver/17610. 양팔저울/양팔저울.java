import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max += arr[i];
        }
        pos = new boolean[max + 1];
        int sum = 0;
        weigh(arr, sum, n, 0);
        int count = 0;
        for (int i = 1; i <= max; i++) {
            if (!pos[i]) {
                count++;
            }
        }
        System.out.println(count);
    }

    static void weigh(int[] arr, int sum, int n, int depth) {
        if (depth == n) {
            if (sum > 0) {
                pos[sum] = true;
            }
            return;
        }
        weigh(arr, sum + arr[depth], n, depth + 1); // 왼쪽 저울에 올리기
        weigh(arr, sum - arr[depth], n, depth + 1); // 오른쪽 저울에 올리기
        weigh(arr, sum, n, depth + 1); //저울에 안올리기
    }
}
