import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }
        int count = 0;

        while (!queue.isEmpty()) {
            if (++count % k == 0) {
                result.add(queue.poll());
            } else {
                queue.add(queue.poll());
            }
        }
        String s = result.toString();
        String substring = s.substring(1, s.length() - 1);
        System.out.println("<" + substring + ">");
    }
}