import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[] arr, lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());
        for (int tCase = 1; tCase <= T; tCase++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            lis = new int[N];

            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            } //input end

            int lisIdx = 0;
            lis[lisIdx] = arr[0];
            for (int i = 1; i < N; i++) {
                if (lis[lisIdx] < arr[i]) {
                    lis[++lisIdx] = arr[i];
                } else {
//                    int tmp = Arrays.binarySearch(lis, arr[i]);
//                    int insertIdx = (tmp + 1) * -1;
                    int insertIdx = binarySearch(0, lisIdx, arr[i]);
                    lis[insertIdx] = arr[i];
                }
            }
            sb.append("#").append(tCase).append(" ").append(lisIdx + 1);
            System.out.println(sb);
        }
    }

    /**
     * @param L -> lis Start Index
     * @param R -> lis End Index
     * @param n -> insert Value
     * @return -> insert Position
     */
    static int binarySearch(int L, int R, int n) {
        int mid = 0;
        while (L < R) {
            mid = (L + R) / 2;
            if (n <= lis[mid]) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return L;
    }
}