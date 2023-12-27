import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {
    static int n, a, b, w;

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        n = sc.nextInt();
        w = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int k = 0;

        for (int i = 1; i < n; i++) {
            if (((i * a) + (n - i) * b) == w) {
                k++;
                sb.append(i).append(" ");
                sb.append(n - i);
            }
        }

        if (k != 1) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}