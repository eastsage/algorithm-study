import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
    static int n, m, result;
    static int[][] map;
    static List[] edges;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(charArray[j]);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || map[i][j] == 0) continue;
                int cnt = 0;
                result++;
                cnt += recur(i, j);
                list.add(cnt);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    static int recur(int x, int y) {
        visited[x][y] = true;
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (visited[nx][ny] || map[nx][ny] == 0) continue;
            cnt += recur(nx, ny);
        }

        return cnt;
    }
}