import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = 0;
        int b = 0;
        List<Integer> list = new ArrayList<>();
        while (3 * a <= n) {
            for (b = 0; 5 * b <= n; b++) {
                if (3 * a + 5 * b == n) {
                    list.add(a + b);
                }
            }
            a++;
        }
        if (list.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(Collections.min(list));
        }
    }
}
