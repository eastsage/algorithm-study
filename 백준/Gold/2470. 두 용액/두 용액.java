import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, m;
    static int[] arr, parent, lev;
    static List<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int a = 0, b = 0;
        int s = 0;
        int e = n - 1;
        int min = Integer.MAX_VALUE;
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                a = arr[s];
                b = arr[e];
                if (sum == 0) break;
            }
            if (sum < 0) s++;
            else e--;

        }
        System.out.println(a + " " + b);
    }
}