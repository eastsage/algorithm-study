import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char arr[] = new char[s.length()];
        int alphabet[] = new int[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == 'a')
                if (alphabet[0] == -1)
                    alphabet[0] = i;

            if (arr[i] == 'b')
                if (alphabet[1] == -1)
                    alphabet[1] = i;

            if (arr[i] == 'c')
                if (alphabet[2] == -1)
                    alphabet[2] = i;

            if (arr[i] == 'd')
                if (alphabet[3] == -1)
                    alphabet[3] = i;

            if (arr[i] == 'e')
                if (alphabet[4] == -1)
                    alphabet[4] = i;

            if (arr[i] == 'f')
                if (alphabet[5] == -1)
                    alphabet[5] = i;

            if (arr[i] == 'g')
                if (alphabet[6] == -1)
                    alphabet[6] = i;

            if (arr[i] == 'h')
                if (alphabet[7] == -1)
                    alphabet[7] = i;

            if (arr[i] == 'i')
                if (alphabet[8] == -1)
                    alphabet[8] = i;

            if (arr[i] == 'j')
                if (alphabet[9] == -1)
                    alphabet[9] = i;

            if (arr[i] == 'k')
                if (alphabet[10] == -1)
                    alphabet[10] = i;

            if (arr[i] == 'l')
                if (alphabet[11] == -1)
                    alphabet[11] = i;

            if (arr[i] == 'm')
                if (alphabet[12] == -1)
                    alphabet[12] = i;

            if (arr[i] == 'n')
                if (alphabet[13] == -1)
                    alphabet[13] = i;

            if (arr[i] == 'o')
                if (alphabet[14] == -1)
                    alphabet[14] = i;

            if (arr[i] == 'p')
                if (alphabet[15] == -1)
                    alphabet[15] = i;

            if (arr[i] == 'q')
                if (alphabet[16] == -1)
                    alphabet[16] = i;

            if (arr[i] == 'r')
                if (alphabet[17] == -1)
                    alphabet[17] = i;

            if (arr[i] == 's')
                if (alphabet[18] == -1)
                    alphabet[18] = i;

            if (arr[i] == 't')
                if (alphabet[19] == -1)
                    alphabet[19] = i;

            if (arr[i] == 'u')
                if (alphabet[20] == -1)
                    alphabet[20] = i;

            if (arr[i] == 'v')
                if (alphabet[21] == -1)
                    alphabet[21] = i;

            if (arr[i] == 'w')
                if (alphabet[22] == -1)
                    alphabet[22] = i;

            if (arr[i] == 'x')
                if (alphabet[23] == -1)
                    alphabet[23] = i;

            if (arr[i] == 'y')
                if (alphabet[24] == -1)
                    alphabet[24] = i;

            if (arr[i] == 'z')
                if (alphabet[25] == -1)
                    alphabet[25] = i;
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(alphabet[i] + " ");
        }


    }
}
