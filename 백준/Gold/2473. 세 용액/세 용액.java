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
        long min = Long.MAX_VALUE;
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < n - 1; i++) {
            int s = i + 1;
            int e = n - 1;
            while (s < e) {
                long sum = (long) arr[s] + arr[e] + arr[i];
                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    a = arr[s];
                    b = arr[e];
                    c = arr[i];
                }
                if (sum < 0) s++;
                else e--;
            }
        }
        int[] result = {a, b, c};
        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}