import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 500; i++) {
            double a = Math.pow(i, 2);
            for (int j = i + 1; j <= 500; j++) {
                double b = Math.pow(j, 2);
                if (a + n == b) {
                    result++;
                }
            }
        }
        System.out.println(result);

    }
}