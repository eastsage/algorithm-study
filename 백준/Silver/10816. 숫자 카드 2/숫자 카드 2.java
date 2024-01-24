import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr1;
    static int[] arr2;
    static int n, m;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        m = Integer.parseInt(br.readLine());
        arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }




        for (int target : arr2) {
            int s = 0, e = arr1.length - 1, tmp = arr1.length;

            while (s <= e) {
                int mid = (s + e) >>> 1; // 나누기 2
                int val = arr1[mid];

                if (target <= val) {
                    e = mid - 1;
                    tmp = mid;
                } else {
                    s = mid + 1;
                }
            }
            int lb = tmp;
            //System.out.println("lb = " + lb);

            if (lb == arr1.length) {
                sb.append(0).append(" ");
                continue;
            }

            s = lb;
            e = arr1.length - 1;
            tmp = arr1.length;
            while (s <= e) {
                int m = (s + e) >>> 1;
                int val = arr1[m];

                if (target < val) {
                    e = m - 1;
                    tmp = m;
                } else {
                    s = m + 1;
                }
            }
            int rb = tmp;

            sb.append(rb - lb).append(" ");
        }
        System.out.println(sb);
    }
}