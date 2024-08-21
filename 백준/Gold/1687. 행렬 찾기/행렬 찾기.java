import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = s.charAt(j - 1) - '0';
            }
        }

        int maxArea = 0;
        int[] height = new int[m + 1]; // 높이
        int[] left = new int[m + 1];   // 왼쪽 경계
        int[] right = new int[m + 1];  // 오른쪽 경계

        for (int i = 1; i <= m; i++) {
            right[i] = m; // 처음에 오른쪽 경계를 끝으로 설정
        }

        for (int i = 1; i <= n; i++) {
            int curLeft = 1, curRight = m;

            // Calculate height and left
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == 0) {
                    height[j]++;
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    height[j] = 0;
                    left[j] = 1;
                    curLeft = j + 1;
                }
            }


            // Calculate right
            for (int j = m; j >= 1; j--) {
                if (arr[i][j] == 0) {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = m;
                    curRight = j - 1;
                }
            }

            // Calculate area
            for (int j = 1; j <= m; j++) {
                int area = (right[j] - left[j] + 1) * height[j];
                maxArea = Math.max(maxArea, area);
            }
        }

        System.out.println(maxArea);
    }
}