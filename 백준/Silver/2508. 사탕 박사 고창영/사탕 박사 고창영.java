import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int t, r, c, result;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            result = 0;
            br.readLine();
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map = new char[r][c];
            Queue<int[]> right = new ArrayDeque<>();
            Queue<int[]> down = new ArrayDeque<>();
            for (int j = 0; j < r; j++) {
                char[] tmp = br.readLine().toCharArray();
                for (int k = 0; k < c; k++) {
                    if (tmp[k] == 62) {
                        right.offer(new int[]{j, k});
                    } else if (tmp[k] == 118) {
                        down.offer(new int[]{j, k});
                    }
                    map[j] = tmp;
                }
            }

            while (!right.isEmpty()) {
                int[] cur = right.poll();
                int x = cur[0];
                int y = cur[1];
                if (c - 3 < y) {
                    continue;
                }
                if (map[x][y + 1] == 111 && map[x][y + 2] == 60) {
                    result++;
                }
            }
            while (!down.isEmpty()) {
                int[] cur = down.poll();
                int x = cur[0];
                int y = cur[1];
                if (r - 3 < x) {
                    continue;
                }
                if (map[x + 1][y] == 111 && map[x + 2][y] == 94) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}