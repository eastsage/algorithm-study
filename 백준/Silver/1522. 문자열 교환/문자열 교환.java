import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') total++;
        }

        int aMax = 0;
        for (int i = 0; i < s.length(); i++) {
            int aCnt = 0;

            for (int j = 0; j < total; j++) {
                int index = (i + j < s.length() ? i + j : i + j - s.length());

                if (s.charAt(index) == 'a') aCnt++;

                if (aCnt > aMax) aMax = aCnt;
            }
        }

        System.out.println(total - aMax);
    }
}