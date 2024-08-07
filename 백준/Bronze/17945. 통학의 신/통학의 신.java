import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {
    static int n, a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        a *= 2;
        b = Integer.parseInt(st.nextToken());
        Set<Integer> result = new TreeSet<>();

        for (int i = -1000; i <= 1000; i++) {
            for (int j = -1000; j <= 1000; j++) {

                if (a == (i + j) * -1) {
                    if (i * j == b) {
                        result.add(i);
                        result.add(j);
                        for (Integer integer : result) {
                            System.out.print(integer + " ");
                        }
                        return;
                    }
                }
            }
        }
    }
}