import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static StringBuilder sb;
    static int dr[] = {0, 0, 1, 1};
    static int dc[] = {0, 1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        if (canCompress(0, 0, n)) {
            System.out.println(arr[0][0]);
            return;
        }
        compress(0, 0, n);
        System.out.println(sb);
    }

    static void compress(int r, int c, int size) {
        int half = size / 2;
        sb.append("(");

        for (int i = 0; i < 4; i++) {
            if (canCompress(r + (dr[i] * half), c + (dc[i] * half), half)) {
                sb.append(arr[r + (dr[i] * half)][c + (dc[i] * half)]);
            } else {
                compress(r + (dr[i] * half), c + (dc[i] * half), half);
            }
        }

        sb.append(")");
    }

    private static boolean canCompress(int r, int c, int size) {
        int color = arr[r][c];
        boolean isValid = true;
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != color) {
                    isValid = false;
                    break;
                }
            }
        }
        return isValid;
    }
}