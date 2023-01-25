import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            backTracking(arr, visited, 0, n, i);
        }
        System.out.println(min);
    }

    /**
     * 백트래킹 사용한 조합
     * @param arr -> 하나씩 뽑을 배열
     * @param visited -> 뽑았는지 확인할 배열
     * @param start -> 기준 index
     * @param n -> 배열의 길이
     * @param r -> 조합의 길이
     */
    static void backTracking(int[][] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            getMin(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            backTracking(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    /**
     * 재귀 사용한 조합
     * @param arr -> 하나씩 뽑을 배열
     * @param visited -> 뽑았는지 확인할 배열
     * @param depth -> 현재 index
     * @param n -> 배열의 길이
     * @param r -> 조합의 길이
     */
//    static void recursion(int[][] arr, boolean[] visited, int depth, int n, int r) {
//        if (r == 0) {
//            getMin(arr, visited, n);
//            return;
//        }
//
//        if (depth == n) {
//            return;
//        }
//
//        visited[depth] = true;
//        recursion(arr, visited, depth + 1, n, r - 1);
//
//        visited[depth] = false;
//        recursion(arr, visited, depth + 1, n, r);
//    }

    static void getMin(int[][] arr, boolean[] visited, int n) {
        int sum = 0;
        int times = 1;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                times *= arr[i][0];
                sum += arr[i][1];
            }
        }
        min = Math.min(Math.abs(times - sum), min);
    }
}