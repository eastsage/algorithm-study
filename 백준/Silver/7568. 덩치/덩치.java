import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<P> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            P p = new P();
            p.weight = sc.nextInt();
            p.height = sc.nextInt();
            list.add(p);
        }
        for (P p : list) {
            int count = 0;
            for (P p1 : list) {
                if (p1.weight > p.weight && p1.height > p.height) {
                    count++;
                }
            }
            System.out.print(count + 1 + " ");
        }
    }

    static class P {
        int weight;
        int height;
    }
}
