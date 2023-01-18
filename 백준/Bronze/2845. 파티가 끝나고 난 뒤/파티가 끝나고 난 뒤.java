import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        int scale = sc.nextInt();
        int mul = people * scale;
        int news = 0;

        for (int i = 0; i < 5; i++) {
            news = sc.nextInt();
            System.out.println(news - mul);
        }


    }                           
}                               
                  