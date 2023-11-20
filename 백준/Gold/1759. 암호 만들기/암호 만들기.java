import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int l, c;
    static char[] arr, code;
    //    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    static List<Character> vowels = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        code = new char[l];
        arr = new char[c];

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        arr = br.readLine().replace(" ", "").toCharArray();
        Arrays.sort(arr);
        recur(0, 0);
    }

    static void recur(int depth, int start) {
        if (depth >= l) {
            int cnt = 0;
            for (char alpha : code) {
                if (vowels.contains(alpha)) {
                    cnt++;
                }
            }
            if (cnt >= 1 && cnt <= l - 2) {
                System.out.println(new String(code));
                return;
            }
            return;
        }

        for (int i = start; i < c; i++) {
            code[depth] = arr[i];
            recur(depth + 1, i + 1);
        }
    }
}