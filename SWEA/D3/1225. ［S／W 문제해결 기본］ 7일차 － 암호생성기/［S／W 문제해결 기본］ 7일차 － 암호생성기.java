import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < 8; i++) {
                q.offer(Integer.valueOf(st.nextToken()));
            }
            int i = 0;
            while (true) {
                i++;
                Integer poll = q.poll();
                if (poll <= i) {
                    q.offer(0);
                    break;
                }
                q.offer(poll - i);
                if (i == 5) {
                    i = 0;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#" + test_case);
            for (Integer num : q) {
                sb.append(" " + num);
            }
            System.out.println(sb.toString());
        }
    }
}