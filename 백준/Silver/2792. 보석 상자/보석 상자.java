import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n, m, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        int low = 1;
        int high = 0;
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, arr[i]);
        }

        // 최대한 잘게 나누어서 모두에게 나눠 줘야함
        while (low <= high) {
            int mid = (low + high) / 2;

            if (isValid(mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(result);
    }

    static boolean isValid(int high) {
        int count = 0;

        for (int jewel : arr) {
            count += (int) Math.ceil((double) jewel / high);
        }

        return count <= n;
    }
}