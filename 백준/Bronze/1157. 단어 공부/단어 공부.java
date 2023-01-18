import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s = s.toUpperCase();
        char ch = '?';
        int max = -1;
        int arr[] = new int[26]; //A~Z 65~90

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 65]++;
        }

        for (int i = 0; i < 26; i++) {
            if (max < arr[i]) {
                max = arr[i];
                ch = (char)(i+65);
            }
            else if (max == arr[i])
                ch = '?';
        }
        System.out.println(ch);

    }
}
