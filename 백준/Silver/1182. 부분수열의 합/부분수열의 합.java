import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, s, result;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        recur(0, 0, 0);
        System.out.println(result);
    }

    static void recur(int depth, int sum, int size) {
        if (depth >= n) {
            if (sum == s && size != 0) {
                result++;
            }
            return;
        }

        recur(depth + 1, sum + arr[depth], size + 1);
        recur(depth + 1, sum, size);
    }
}