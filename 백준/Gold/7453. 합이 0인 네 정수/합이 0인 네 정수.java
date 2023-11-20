import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long cnt;
    static int[] ab, cd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        ab = new int[n * n];
        cd = new int[n * n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[k] = A[i] + B[j];
                cd[k++] = C[i] + D[j];
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);
        // primitive(pivot quicksort) > wrapper(merge sort)
//        Arrays.sort(cd, Comparator.reverseOrder());

        int p1 = 0;
        int p2 = cd.length - 1;
        int end = n * n;

        while (p1 < end && 0 <= p2) {
            int sum = ab[p1] + cd[p2];
            long p1Cnt = 1;
            long p2Cnt = 1;

            if (sum == 0) {
                while (p1 <= end - 2 && ab[p1] == ab[p1 + 1]) {
                    p1Cnt++;
                    p1++;
                }

                while (0 < p2 && cd[p2] == cd[p2 - 1]) {
                    p2Cnt++;
                    p2--;
                }
                cnt += p1Cnt * p2Cnt;
            }
            if (sum < 0) {
                p1++;
            } else {
                p2--;
            }
        }
        System.out.println(cnt);
    }
}