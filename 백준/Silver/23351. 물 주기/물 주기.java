import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int n, k, a, b, day;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        arr = new int[n];
        Arrays.fill(arr, k);

        while (true) {
            day++;
            //최소 값 찾고 업데이트
            int minIdx = findMinIdx();
            if (minIdx + a >= n) {
                minIdx = n - a;
            }
            for (int i = minIdx; i < minIdx + a; i++) {
                arr[i] += b;
            }

            //1씩 감소
            //죽은놈 체크
            for (int i = 0; i < n; i++) {
                arr[i]--;
                if (arr[i] <= 0) {
                    System.out.println(day);
                    return;
                }
            }
        }
    }

    static int findMinIdx() {
        int min = 101;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
                idx = i;
            }
        }
        return idx;
    }
}