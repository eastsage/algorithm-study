import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, r, c, d;
    static int[][] arr;
    static int count = 1; //시작 지점은 항상 청소되어 있지 않음
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);
        System.out.println(count);
    }

    public static void dfs(int x, int y, int dir) {

        arr[x][y] = -1;

        for(int i = 0; i < 4; i++) {
            dir = (dir+3)%4;

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if(arr[nx][ny] == 0) {
                    count++;
                    dfs(nx, ny, dir);
                    return;
                }
            }
        }

        int d = (dir + 2) % 4; //반대 방향으로 후진
        int bx = x + dx[d];
        int by = y + dy[d];
        if(bx >= 0 && by >= 0 && bx < n && by < m && arr[bx][by] != 1) {
            dfs(bx, by, dir); //후진이니까 바라보는 방향은 유지
        }
    }
}