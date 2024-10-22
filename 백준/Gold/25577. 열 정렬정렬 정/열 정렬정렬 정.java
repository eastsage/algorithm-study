import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr, sortedArr;
    static int[][] map, dp;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        sortedArr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = arr[i];
        }
        Arrays.sort(sortedArr);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sortedArr[i], i);
        }
        int swapCnt = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int size = 0;
            int x = i;

            while (!visited[x]) {
                visited[x] = true;
                size++;
                x = map.get(arr[x]);
            }
            if (size > 1) {
                swapCnt += size - 1;
            }
        }
        System.out.println(swapCnt);

    }
}
//0 1   2   3       300 400 9012
//1 300 2   9012    3   400 0