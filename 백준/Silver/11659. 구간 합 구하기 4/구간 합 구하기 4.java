import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }

        int[] start = new int[m];
        int[] end = new int[m];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
            sb.append(arr[end[i]] - arr[start[i] - 1]);
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}