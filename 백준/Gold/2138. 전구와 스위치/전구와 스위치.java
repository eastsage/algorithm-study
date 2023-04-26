import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[] bulbs1, bulbs2;
    static boolean[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        bulbs1 = new boolean[n];
        bulbs2 = new boolean[n];
        answer = new boolean[n];
        int idx = 0;
        for (char c : br.readLine().toCharArray()) {
            if (c == '1') {
                bulbs1[idx] = true;
                bulbs2[idx] = true;
            }
            idx++;
        }
        idx = 0;
        for (char c : br.readLine().toCharArray()) {
            if (c == '1') {
                answer[idx] = true;
            }
            idx++;
        }//input end

        pressSwitch2(0);

        int cnt1 = 0;
        int cnt2 = 1;
        for (int i = 1; i < n; i++) {
            if (answer[i - 1] != bulbs1[i - 1]) {
                pressSwitch1(i);
                cnt1++;
            }
            if (answer[i - 1] != bulbs2[i - 1]) {
                pressSwitch2(i);
                cnt2++;
            }
        }

        if (Arrays.equals(bulbs1, answer) && Arrays.equals(bulbs2, answer)) {
            System.out.println(Math.min(cnt1, cnt2));
        } else if (Arrays.equals(bulbs1, answer)) {
            System.out.println(cnt1);
        } else if (Arrays.equals(bulbs2, answer)) {
            System.out.println(cnt2);
        } else {
            System.out.println(-1);
        }
    }

    static void pressSwitch1(int a) {
        if (a == 0) {
            changeBulb1(a);
            changeBulb1(a + 1);
        } else if (a == n - 1) {
            changeBulb1(a - 1);
            changeBulb1(a);
        } else {
            changeBulb1(a - 1);
            changeBulb1(a);
            changeBulb1(a + 1);
        }
    }
    static void pressSwitch2(int a) {
        if (a == 0) {
            changeBulb2(a);
            changeBulb2(a + 1);
        } else if (a == n - 1) {
            changeBulb2(a - 1);
            changeBulb2(a);
        } else {
            changeBulb2(a - 1);
            changeBulb2(a);
            changeBulb2(a + 1);
        }
    }

    static void changeBulb1(int a) {
        bulbs1[a] = !bulbs1[a];
    }
    static void changeBulb2(int a) {
        bulbs2[a] = !bulbs2[a];
    }
}