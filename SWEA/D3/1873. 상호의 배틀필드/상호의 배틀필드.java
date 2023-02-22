import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
//    문자	의미
//      . 	평지(전차가 들어갈 수 있다.)
//      *	벽돌로 만들어진 벽
//      #	강철로 만들어진 벽
//      -	물(전차는 들어갈 수 없다.)
//      ^	위쪽을 바라보는 전차(아래는 평지이다.)
//      v	아래쪽을 바라보는 전차(아래는 평지이다.)
//      <	왼쪽을 바라보는 전차(아래는 평지이다.)
//      >	오른쪽을 바라보는 전차(아래는 평지이다.)
    static char[][] map;
    static Loc loc;
    static int H, W, startY, startX;
    static final char up = '^';
    static final char down = 'v';
    static final char left = '<';
    static final char right = '>';
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tCase = 1; tCase <= T; tCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            int cur;
            for (int i = 0; i < H; i++) {
                char[] inputs = br.readLine().toCharArray();
                for (int j = 0; j < inputs.length; j++) {
                    map[i][j] = inputs[j];
                    if (inputs[j] == up || inputs[j] == down || inputs[j] == left || inputs[j] == right) {
                        loc = new Loc(i, j, inputs[j]);
                        startY = i;
                        startX = j;
                        map[i][j] = '.';
                    }
                }
            }
            int n = Integer.parseInt(br.readLine());
            String commands = br.readLine();

            for (int i = 0; i < n; i++) {
                char input = commands.charAt(i);
                if (input == 'S') {
                    shoot();
                } else {
                    move(input);
                }
            }

            map[loc.y][loc.x] = loc.direction;

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tCase).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                if (i != H - 1) {
                    sb.append("\n");
                }
            }
            System.out.println(sb);
        }
    }
    static void move(char c) {
        if (c == 'U') {
            loc.direction = up;
            if (loc.y > 0 && map[loc.y - 1][loc.x] == '.') {
                loc.y--;
            }
        }
        if (c == 'D') {
            loc.direction = down;
            if (loc.y < H - 1 && map[loc.y + 1][loc.x] == '.') {
                loc.y++;
            }
        }
        if (c == 'L') {
            loc.direction = left;
            if (loc.x > 0 && map[loc.y][loc.x - 1] == '.') {
                loc.x--;
            }
        }
        if (c == 'R') {
            loc.direction = right;
            if (loc.x < W - 1 && map[loc.y][loc.x + 1] == '.') {
                loc.x++;
            }
        }
    }
    static void shoot() {
        if (loc.direction == up) {
            int bullet = loc.y;
            while (bullet-- > 0) {
                if (map[bullet][loc.x] == '*') {
                    map[bullet][loc.x] = '.';
                    return;
                }
                if (map[bullet][loc.x] == '#') {
                    return;
                }
            }
        }
        if (loc.direction == down) {
            int bullet = loc.y;
            while (bullet++ < H - 1) {
                if (map[bullet][loc.x] == '*') {
                    map[bullet][loc.x] = '.';
                    return;
                }
                if (map[bullet][loc.x] == '#') {
                    return;
                }
            }
        }
        if (loc.direction == left) {
            int bullet = loc.x;
            while (bullet-- > 0) {
                if (map[loc.y][bullet] == '*') {
                    map[loc.y][bullet] = '.';
                    return;
                }
                if (map[loc.y][bullet] == '#') {
                    return;
                }
            }
        }
        if (loc.direction == right) {
            int bullet = loc.x;
            while (bullet++ < W - 1) {
                if (map[loc.y][bullet] == '*') {
                    map[loc.y][bullet] = '.';
                    return;
                }
                if (map[loc.y][bullet] == '#') {
                    return;
                }
            }
        }
    }
}

class Loc {
    int y;
    int x;
    char direction;

    public Loc(int y, int x, char direction) {
        this.y = y;
        this.x = x;
        this.direction = direction;
    }
}