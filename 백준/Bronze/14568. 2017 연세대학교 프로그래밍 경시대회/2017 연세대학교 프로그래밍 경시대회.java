import java.io.*;

public class Main {
    static int n, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        if (n < 6) {
            System.out.println(0);
            return;
        }

        for (int a = 2; a <= n; a += 2) {
            for (int b = 1; b <= n - a - 1; b++) {
                int c = n - a - b;
                if (c >= b + 2) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}