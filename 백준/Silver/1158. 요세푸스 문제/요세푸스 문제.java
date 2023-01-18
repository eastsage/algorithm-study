import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 1;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        sb.append("<");

        // k배수마다 빼버리고 출력 아니면 뒤로 넣기
        while (!queue.isEmpty()) {
            if (count % k == 0) {
                if (queue.size()==1) {
                    sb.append(queue.poll() + ">");
                } else {
                    sb.append(queue.poll() + ", ");
                }
            } else {
                queue.peek();
                queue.offer(queue.poll());
            }
            count++;
        }
        System.out.println(sb);
    }
}
