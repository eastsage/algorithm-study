import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1]; //입력받은 배열
        int[] dp = new int[n + 1]; // 누적할 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i] + dp[i - 1]; // 누적합
        }
        int max = Integer.parseInt(br.readLine()); // 최대 칸수 입력


        int[][] dp2 = new int[n + 1][4];  // dp 2차원 배열

        int result = 0;

        for (int i = 1; i < 4; i++) { // 몇대를 이용했을 때의 최대값 구하는 반복문
            for (int j = max; j < n + 1; j++) { // 누적되있으므로 max부터 시작 max전에는 최대칸만큼 누적이 안됬기 때문
                dp2[j][i] = Math.max(dp[j] - dp[j - max] + dp2[j - max][i - 1], dp2[j - 1][i]);


                result = Math.max(result, dp2[j][3]);
            }

        }
        System.out.println(result);
    }
}