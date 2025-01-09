import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int n, m, k, s, e;
    static int[] pSum, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        s = 0;
        e = n - 1;
        long res = arr[e--];

        for (int i = 1; i < k; i++) {
            if (i % 2 == 0) {
                res += arr[e--] - arr[s - 1];
            } else {
                s++;
            }
        }
        System.out.println(res);
    }
}