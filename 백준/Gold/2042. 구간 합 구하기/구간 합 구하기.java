import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Long> arr = new ArrayList<>();
        ArrayList<Long> tree = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            arr.add(0L);
            tree.add(0L);
        }

        for (int i = 1; i <= n; i++) {
            long num = sc.nextLong();
            arr.set(i, num);
            update(tree, i, num);
        }

        m += k;

        while (m-- > 0) {
            int num = sc.nextInt();

            if (num == 1) {
                int index = sc.nextInt();
                long val = sc.nextLong();

                long diff = val - arr.get(index);
                arr.set(index, val);

                update(tree, index, diff);
            } else if (num == 2) {
                int left = sc.nextInt();
                int right = sc.nextInt();

                System.out.println(sum(tree, right) - sum(tree, left - 1));
            }
        }

        sc.close();
    }

    public static long sum(ArrayList<Long> tree, int i) {
        long ans = 0;
        while (i > 0) {
            ans += tree.get(i);
            i -= (i & -i);
        }
        return ans;
    }

    public static void update(ArrayList<Long> tree, int i, long diff) {
        while (i < tree.size()) {
            tree.set(i, tree.get(i) + diff);
            i += (i & -i);
        }
    }
}