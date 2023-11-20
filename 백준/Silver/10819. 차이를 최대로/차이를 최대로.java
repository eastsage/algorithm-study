import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, max;
    static int[] arr, result;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        result = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        recur(0);
        System.out.println(max);
    }
    static void recur(int depth) {
        if (depth >= n) {
//            System.out.println(Arrays.toString(result));
//            System.out.println("max = " + max);
            updateMax();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            result[depth] = arr[i];
            recur(depth + 1);
            visited[i] = false;
        }
    }

    static void updateMax() {
        int tmp = 0;
        for (int i = 0; i < n - 1; i++) {
            tmp += Math.abs(result[i] - result[i + 1]);
        }
        max = Math.max(tmp, max);
    }
}