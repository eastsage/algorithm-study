import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ra = (a%10)*100 + ((a/10)%10)*10 + (a/100);
        int rb = (b%10)*100 + ((b/10)%10)*10 + (b/100);
        int answer;

        if (ra > rb)
            System.out.println(ra);
        else
            System.out.println(rb);
    }
}