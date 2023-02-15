import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue q = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) > Math.abs(o2)) {
                    return 1;
                } else if (Math.abs(o1) == Math.abs(o2)) {
                    if (o1 > o2) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }

        });

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (q.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(q.poll());
                }
            } else {
                q.offer(input);
            }
        }
    }
}