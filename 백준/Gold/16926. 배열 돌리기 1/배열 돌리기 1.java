import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, r, cnt;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        cnt = Math.min(n, m) / 2;
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < cnt; j++) {
                int temp = arr[j][j];
                for (int k = j + 1; k < m - j; k++) {
                    arr[j][k - 1] = arr[j][k];
                }
                for (int k = j + 1; k < n - j; k++) {
                    arr[k - 1][m - 1 - j] = arr[k][m - 1 - j];
                }
                for (int k = m - 2 - j; k >= j; k--) {
                    arr[n - 1 - j][k + 1] = arr[n - 1 - j][k];
                }
                for (int k = n - 2 - j; k >= j; k--) {
                    arr[k + 1][j] = arr[k][j];
                }
                arr[j + 1][j] = temp;
            }
        }

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                System.out.print(arr[j][k] + " ");
            }
            System.out.println();
        }

    }
}