import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            set.add(arr[i]);
        }
        int max = 1;
        for (Integer k : set) {
            int cnt = 1;
            int pre = arr[0];
            for (int i = 1; i < n; i++) {
                if (arr[i] == k) continue;
                if (arr[i] == pre) {
                    ++cnt;
                    max = Math.max(max, cnt);
                } else {
                    cnt = 1;
                }
                pre = arr[i];
            }
        }
        System.out.println(max);
    }
}