import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr, videoSize;
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int s = 0;
        int e = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (s < arr[i]) s = arr[i];
            e = e + arr[i];
        }
        while (s <= e) {
            int middle = (s + e) / 2;
            int sum = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > middle) {
                    count++;
                    sum = 0;
                }
                sum = sum + arr[i];
            }
            if (sum != 0) count++;
            if (count > m) s = middle + 1;
            else e = middle - 1;
        }
        System.out.println(s);
    }
}