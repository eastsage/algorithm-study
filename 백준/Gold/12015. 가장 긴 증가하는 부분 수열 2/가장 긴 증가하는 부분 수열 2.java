import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        lis = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lisIdx = 1;
        lis[lisIdx] = arr[1];
        for (int i = 1; i <= N; i++) {
            if (lis[lisIdx] < arr[i]) {
                lis[++lisIdx] = arr[i];
            } else {
                int insertIdx = binarySearch(1, lisIdx, arr[i]);
                lis[insertIdx] = arr[i];
            }
        }
        System.out.println(lisIdx);
    }

    private static int binarySearch(int L, int R, int n) {
        int mid = 0;
        while (L < R) {
            mid = (L + R) / 2;
            if (n <= lis[mid]) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return L;
    }
}