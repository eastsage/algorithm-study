import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, m, x, y, k;
    static int[][] map;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        Dice dice = new Dice(0, 0, 0, 0, 0, 0);
        // 동서북남1234
        for (int i = 0; i < k; i++) {
            int command = Integer.parseInt(st.nextToken());
            int nx = x + dx[command];
            int ny = y + dy[command];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            x = nx;
            y = ny;

            dice.roll(command);
            sb.append(dice.top).append("\n");
            if (map[x][y] == 0) {
                map[x][y] = dice.bottom;
            } else {
                dice.bottom = map[x][y];
                map[x][y] = 0;
            }
        }
        System.out.println(sb);

    }
    private static class Dice {
        private int top;
        private int bottom;
        private int north;
        private int south;
        private int east;
        private int west;

        public Dice(int top, int bottom, int north, int south, int east, int west) {
            this.top = top;
            this.bottom = bottom;
            this.north = north;
            this.south = south;
            this.east = east;
            this.west = west;
        }

        public void roll(int command) {
            if (command == 1) {
                rollEast();
            } else if (command == 2) {
                rollWest();
            } else if (command == 3) {
                rollNorth();
            } else {
                rollSouth();
            }
        }

        public void rollNorth() {
            int temp = top;
            top = south;
            south = bottom;
            bottom = north;
            north = temp;
        }

        public void rollSouth() {
            int temp = top;
            top = north;
            north = bottom;
            bottom = south;
            south = temp;
        }

        public void rollEast() {
            int temp = top;
            top = west;
            west = bottom;
            bottom = east;
            east = temp;
        }

        public void rollWest() {
            int temp = top;
            top = east;
            east = bottom;
            bottom = west;
            west = temp;
        }

    }
}