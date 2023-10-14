import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static long  min, max;
    static char[] chars;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[10];
        chars = br.readLine().replace(" ", "").toCharArray();

        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;

        recur(0);
        System.out.println(max);
        if (min / Math.pow(10, n) < 1) {
            System.out.print(0);
        }
        System.out.println(min);
    }
    static void recur(int depth) {
        if (depth > n) {
            if (check()) {
                long l = arrToNum();
                if (max < l) {
                    max = l;
                }
                if (min > l) {
                    min = l;
                }
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[depth] = i;
            recur(depth + 1);
            visited[i] = false;
        }
    }

    static boolean check() {
        for (int i = 0; i < n; i++) {
            if (chars[i] == '>') {
                if (arr[i] < arr[i + 1]) {
                    return false;
                }
            } else {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    static long arrToNum() {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        return Long.parseLong(sb.toString());
    }
}