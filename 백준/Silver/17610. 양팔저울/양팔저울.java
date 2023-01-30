import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Set<Integer> set = new HashSet<>();

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
        int sum = 0;
        weigh(arr, sum, n, 0);
        System.out.println(max - set.size());
    }

    static void weigh(int[] arr, int sum, int n, int depth) {
        if (depth == n) {
            if (sum > 0) {
                set.add(sum);
            }
            return;
        }
        weigh(arr, sum + arr[depth], n, depth + 1); // 왼쪽 저울에 올리기
        weigh(arr, sum - arr[depth], n, depth + 1); // 오른쪽 저울에 올리기
        weigh(arr, sum, n, depth + 1); //저울에 안올리기
    }
}
