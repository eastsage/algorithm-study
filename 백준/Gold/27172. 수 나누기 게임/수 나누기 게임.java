import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, max;
    static int[] arr, result;
    static boolean[] num;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        result = new int[1_000_001];
        num = new boolean[1_000_001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            num[arr[i]] = true;
            max = Math.max(max, arr[i]);
        }

        for (int i : arr) {
            for (int j = i * 2; j < 1_000_001; j += i) {
                if (num[j]) {
                    result[i]++;
                    result[j]--;
                }
            }
        }
        for (int i : arr) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}