import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int x;
    static int y;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int k = 1; k <= 10; k++) {
            String testCase = br.readLine();
            System.out.print("#" + testCase + " ");
            map = new int[100][100];

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        x = j;
                        y = 99;
                    }
                }
            }
            move();
            x = 0;
            y = 0;
        }
    }
    static void move() {
        while (y != 0) {
            if (x == 0) {
                if (map[y][x + 1] == 1) {
                    moveRight();
                }
            } else if (x == 99) {
                if (map[y][x - 1] == 1) {
                    moveLeft();
                }
            } else {
                if (map[y][x + 1] == 1) {
                    moveRight();
                } else if (map[y][x - 1] == 1) {
                    moveLeft();
                }
            }
            y--;
        }
        System.out.println(x);
    }

    private static void moveRight() {
        while (map[y][x + 1] == 1) {
            x++;
            if (x == 99) {
                break;
            }
        }
    }

    private static void moveLeft() {
        while (map[y][x - 1] == 1) {
            x--;
            if (x == 0) {
                break;
            }
        }
    }
}