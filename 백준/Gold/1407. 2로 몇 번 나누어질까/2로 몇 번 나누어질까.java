import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int powA, powB;
    static long result, a, b;

    public static void main(String[] args) throws IOException {
        /**
         * 1 2 3 4 5 6 7 8 9 10 11 -> a~b 갯수만큼 1을 더함
         *   o   o   o   o   o     -> 2씩 더해야하지만 이미 1을 더했으니 1을 더함
         *       o       o         -> 4씩 더해야하지만 이미 2를 더했으니 2을 더함
         *               o         -> 8씩 더해야하지만 이미 4를 더했으니 4를 더함 (즉 2^(i-1)을 더함)
         *
         * 2의 배수, 4의 배수, 8의 배수
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken()) - 1;
        b = Long.parseLong(st.nextToken());

        long max = 1;
        while (b >= max) {
            max = (long) Math.pow(2, ++powB);
        }
        max = 1;
        while (a >= max) {
            max = (long) Math.pow(2, ++powA);
        }

        for (int i = 1; i < powB; i++) {
            long num = (long) Math.pow(2, i);
            result += (long) Math.pow(2, i - 1) * (b / num);
        }
        for (int i = 1; i < powA; i++) {
            long num = (long) Math.pow(2, i);
            result -= (long) Math.pow(2, i - 1) * (a / num);
        }
        result += b - a;

        System.out.println(result);
    }
}