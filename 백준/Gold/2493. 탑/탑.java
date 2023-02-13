import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] towers = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Tower> stack = new ArrayDeque<>(n);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {

            if (stack.isEmpty()) {
                stack.push(new Tower(i, towers[i]));
                sb.append(0).append(" ");
                continue;
            }
            if (towers[i] <= stack.peek().height) {
                sb.append(stack.peek().pos).append(" ");
                stack.push(new Tower(i, towers[i]));
                continue;
            }
            while (!stack.isEmpty()) {
                if (towers[i] > stack.peek().height) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(new Tower(i, towers[i]));
                        sb.append(0).append(" ");
                        break;
                    }
                } else if (towers[i] <= stack.peek().height) {
                    sb.append(stack.peek().pos).append(" ");
                    stack.push(new Tower(i, towers[i]));
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }
}

class Tower {
    int pos;
    int height;

    public Tower(int pos, int height) {
        this.pos = pos;
        this.height = height;
    }
}