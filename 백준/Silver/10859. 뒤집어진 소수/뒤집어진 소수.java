import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    /**
     * 3, 4, 7 -> no
     * 6 <-> 9
     * 1, 2, 5, 8, 0 그대로
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        if (input.length == 1 && input[0] == '1') {
            System.out.println("no");
            return;
        }
        for (char c : input) {
            if (c == '3' || c == '4' || c == '7') {
                System.out.println("no");
                return;
            }
        }
        StringBuilder sb1 = new StringBuilder();
        for (char c : input) {
            sb1.append(c);
        }
        long num1 = Long.valueOf(sb1.toString());
        long sqrt1 = (long) Math.sqrt(num1);
        for (int i = 2; i <= sqrt1; i++) {
            if (num1 % i == 0) {
                System.out.println("no");
                return;
            }
        }

        char[] reverse = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '6') {
                input[i] = '9';
            } else if (input[i] == '9') {
                input[i] = '6';
            }
            reverse[input.length - 1 - i] = input[i];
        }
        StringBuilder sb2 = new StringBuilder();
        for (char c : reverse) {
            sb2.append(c);
        }
        long num2 = Long.valueOf(sb2.toString());

//        System.out.println(num2);

        long sqrt2 = (long) Math.sqrt(num2);
        for (int i = 2; i <= sqrt2; i++) {
            if (num2 % i == 0) {
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }
}