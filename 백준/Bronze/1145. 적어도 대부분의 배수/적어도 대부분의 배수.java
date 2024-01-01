import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int count = 0;
        int n = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            n++;
            for (int i = 0; i < 5; i++) {
                if (n >= arr[i] && n % arr[i] == 0)
                    count++;
            }
            if (count > 2)
                break;
            count = 0;
        }
        System.out.println(n);
    }
}