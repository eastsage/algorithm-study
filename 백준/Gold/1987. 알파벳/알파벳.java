import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, max;
    static char[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        map = new char[R + 1][C + 1];
        visited = new boolean[26];

        for (int i = 1; i <= R; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 1; j <= C; j++) {
                map[i][j] = row[j - 1];
            }
        }
        visited[map[1][1] - 65] = true;
        move(1, 1, 1);
        System.out.println(max);
    }

    static void move(int r, int c, int cnt) {

        if (c - 1 >= 1 && !visited[map[r][c - 1] - 65]) {
            visited[map[r][c - 1] - 65] = true;
            move(r, c - 1, cnt + 1);
            visited[map[r][c - 1] - 65] = false;
        }
        if (c + 1 <= C && !visited[map[r][c + 1] - 65]) {
            visited[map[r][c + 1] - 65] = true;
            move(r, c + 1, cnt + 1);
            visited[map[r][c + 1] - 65] = false;
        }
        if (r - 1 >= 1 && !visited[map[r - 1][c] - 65]) {
            visited[map[r - 1][c] - 65] = true;
            move(r - 1, c, cnt + 1);
            visited[map[r - 1][c] - 65] = false;
        }
        if (r + 1 <= R && !visited[map[r + 1][c] - 65]) {
            visited[map[r + 1][c] - 65] = true;
            move(r + 1, c, cnt + 1);
            visited[map[r + 1][c] - 65] = false;
        }
        max = Math.max(max, cnt);
    }
}