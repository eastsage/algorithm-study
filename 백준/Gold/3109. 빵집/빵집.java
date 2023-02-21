import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int row, col;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new char[row][col];

        for (int i = 0; i < row; i++) {
            String s = br.readLine();
            map[i] = s.toCharArray();
        }

        int ans = 0;
        
        for (int i = 0; i < row; i++) {
            if (dfs(i, 0)) {
                ans++;
            }
        }
        System.out.println(ans);

    }

    public static boolean dfs(int r, int c) {
        map[r][c] = 'x'; // 성공한놈은 다른 파이프가 지날 수 없고 실패한놈은 다른놈이 와도 실패함

        if (c == col - 1) {
            return true;
        }

        if (r > 0 && map[r - 1][c + 1] == '.') { //오른쪽 아래
            if (dfs(r - 1, c + 1)) {
                return true;
            }
        }
        if (map[r][c + 1] == '.') { //오른쪽
            if (dfs(r, c + 1)) {
                return true;
            }
        }
        if (r + 1 < row && map[r + 1][c + 1] == '.') { //오른쪽 위
            return dfs(r + 1, c + 1);
        }
        return false;
    }
}