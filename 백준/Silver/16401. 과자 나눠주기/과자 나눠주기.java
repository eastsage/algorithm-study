import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int n, k, m, result;
    static int[] dp;
    static int[] arr;
    static boolean[] visited;
    static int[] dx = {-1, -0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        binarySearch(1, arr[n - 1]);
        System.out.println(result);
    }
    static void binarySearch(int s, int e) {
        while (s <= e) {
            int mid = (s + e) / 2;
            int cnt = 0;
            for (int i : arr) {
                cnt += i / mid;
            }
            if (cnt >= m) {
                result = Math.max(result, mid);
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

    }
}