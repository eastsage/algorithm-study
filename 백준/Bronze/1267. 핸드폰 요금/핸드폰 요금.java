import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rep = sc.nextInt();
        int time = 0;
        int m_temp;
        int y_temp;
        int Y = 0; // 30초당 10
        int M = 0; // 60초당 15

        for (int i = 0; i < rep; i++) {
            time = sc.nextInt();
            y_temp = ((time / 30) + 1) * 10;
            m_temp = ((time / 60) + 1) * 15;
            M += m_temp;
            Y += y_temp;
        }
        if (M < Y)
            System.out.println("M " + M);
        else if (M > Y)
            System.out.println("Y " + Y);
        else
            System.out.println("Y M " + Y);

    }
}