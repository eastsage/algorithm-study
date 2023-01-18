import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.strip();
        String arr[] = s.split(" ");
        if (s.isEmpty())
            System.out.println("0");
        else
            System.out.println(arr.length);


    }
}
