import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        a += 44031;

        char ch = (char)a;
        System.out.println(ch);

        //19, 21, 28 -> 11172개
        //아스키코드 44032 = 가  55203 = 힣

    }
}
