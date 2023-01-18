import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isEmpty = true;
        for (int i = 0; i < 5; i++) {
            if (sc.next().contains("FBI")) {
                isEmpty = false;
                System.out.print(i + 1 + " ");
            }
        }
        if (isEmpty) {
            System.out.println("HE GOT AWAY!");
        }
    }
}
