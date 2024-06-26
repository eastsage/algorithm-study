import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, s, m, result;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int S = Integer.parseInt(br.readLine());

        int moveCnt = 0, changeIdx = 0;
        while (moveCnt < S && changeIdx < n - 1) {
            int maxNum = arr.get(changeIdx), maxIdx = -1;

            int idx = changeIdx + 1, count = 1;
            while (moveCnt + count <= S && idx < n) {
                int num = arr.get(idx);
                if (num > maxNum) {
                    maxNum = num;
                    maxIdx = idx;
                }
                count++;
                idx++;
            }

            if (maxIdx != -1) {
                arr.remove(maxIdx);
                arr.add(changeIdx, maxNum);
                moveCnt += maxIdx - changeIdx;
            }
            changeIdx++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
        br.close();
    }
}