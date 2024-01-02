import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());

            for (int j = 2; j <= 1_000_001; j++) {
                if (j == 1_000_001) {
                    System.out.println("YES");
                    break;
                }
                if (num % j == 0) {
                    System.out.println("NO");
                    break;
                }
            }
        }
    }
}