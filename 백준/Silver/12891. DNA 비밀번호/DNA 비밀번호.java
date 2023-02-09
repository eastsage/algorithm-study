import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] count;
    static int validCnt;

    public static void main(String[] args) throws IOException { //A, C, G, T
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int pwdSize = Integer.parseInt(st.nextToken());
        char[] DNA = br.readLine().toCharArray();
        char[] subDNA = Arrays.copyOfRange(DNA, 0, pwdSize);

        count = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count.length; i++) {
            count[i] = Integer.parseInt(st.nextToken());
        }

        for (char c : subDNA) {
            check(c, false);
        }
        if (isValidSubDNA()) {
            validCnt++;
        }

        int lt = 0;
        int rt = pwdSize - 1;

        for (int i = pwdSize; i < S; i++) {
            check(DNA[++rt], false);
            check(DNA[lt++], true);
            if (isValidSubDNA()) {
                validCnt++;
            }
        }
        System.out.println(validCnt);
    }

    static boolean isValidSubDNA() {
        return count[0] <= 0 && count[1] <= 0 && count[2] <= 0 && count[3] <= 0;
    }

    static void check(char c, boolean mode) {
        if (c == 'A') {
            if (mode) {
                count[0]++;
            } else {
                count[0]--;
            }
            return;
        }
        if (c == 'C') {
            if (mode) {
                count[1]++;
            } else {
                count[1]--;
            }
            return;
        }
        if (c == 'G') {
            if (mode) {
                count[2]++;
            } else {
                count[2]--;
            }
            return;
        }
        if (c == 'T') {
            if (mode) {
                count[3]++;
            } else {
                count[3]--;
            }
        }
    }
}