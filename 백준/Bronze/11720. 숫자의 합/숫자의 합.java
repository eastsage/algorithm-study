import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String arr[] = new String[a];
        String s = sc.next();
        arr = s.split("");
        int sum = 0;
        for (int i = 0; i < a; i++) {
            sum += Integer.parseInt(arr[i]);
        }
        System.out.println(sum);
    }
}