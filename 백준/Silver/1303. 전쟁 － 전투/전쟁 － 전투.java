import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int nextX;
    static int nextY;

    static int count;
    static int wCount;
    static int black_count;

    static char map[][];
    static boolean visited[][];

    static int dx[] = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    char color = map[i][j];
                    count = 0;
                    DFS(j, i, color);

                    if (color == 'W') {
                        wCount += count * count;
                    }
                    if (color == 'B') {
                        black_count += count * count;
                    }
                }
            }
        }
        System.out.println(wCount + " " + black_count);
    }

    static void DFS(int x, int y, char color) {
        visited[y][x] = true;
        count += 1;

        for (int i = 0; i < 4; i++) {
            nextY = y + dy[i];
            nextX = x + dx[i];

            // 움직일 수 있고 색이 동일하며 방문하지 않았다면
            if (canMove() && map[nextY][nextX] == color && !visited[nextY][nextX]) {
                DFS(nextX, nextY, map[nextY][nextX]);
            }
        }

    }

    static boolean canMove() { //움직일 수 있는가? (map 범위 내인가?)
        return (0 <= nextY && nextY < m && 0 <= nextX && nextX < n);
    }
}