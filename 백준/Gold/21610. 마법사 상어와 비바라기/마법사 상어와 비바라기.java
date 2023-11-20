import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] clouds;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int n, m;

    // x + n - (dx % n)
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        clouds = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clouds[n][1] = true;
        clouds[n][2] = true;
        clouds[n - 1][1] = true;
        clouds[n - 1][2] = true;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            moveAndFill(dir, dist);
            copy();
            getNextClouds();
        }
        print();
    }

    static void moveAndFill(int dir, int dist) {
        Queue<int[]> tmp = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!clouds[i][j]) continue;
                int curX = (i + (dx[dir] * dist)) % n;
                int curY = (j + (dy[dir] * dist)) % n;
                if (curX < 1) {
                    curX += n;
                }
                if (curY < 1) {
                    curY += n;
                }
                tmp.add(new int[]{curX, curY});
                clouds[i][j] = false;
                map[curX][curY]++;
            }
        }
        while (!tmp.isEmpty()) {
            int[] poll = tmp.poll();
            clouds[poll[0]][poll[1]] = true;
        }
    }

    static void copy() {
        List<int[]> tmp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!clouds[i][j]) continue;
                int sum = 0;

                for (int k = 2; k <= 8; k += 2) {
                    int curX = i + dx[k];
                    int curY = j + dy[k];
                    if (curX < 1 || curY < 1 || curX > n || curY > n || map[curX][curY] < 1) continue;
                    sum++;
                }
                tmp.add(new int[]{i, j, sum});
            }
        }
        for (int[] arr : tmp) {
            map[arr[0]][arr[1]] += arr[2];
        }

    }

    static void getNextClouds() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (clouds[i][j]) {
                    clouds[i][j] = false;
                    continue;
                }

                if (map[i][j] >= 2) {
                    clouds[i][j] = true;
                    map[i][j] -= 2;
                }
            }
        }
    }

    static void print() {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }
}