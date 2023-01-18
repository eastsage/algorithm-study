import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        int sum = 0;
        int a = 0;
        List<Integer> list2 = new ArrayList<>();
        for (Integer integer : list) {
            a += integer;
            list2.add(a);
        }
        for (Integer integer : list2) {
            sum += integer;
        }
        System.out.println(sum);
    }
}