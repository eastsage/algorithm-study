import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int x;
    static int y;
    static int size;
    static int direction = 0;
    static int num;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tCase; i++) {
            size = Integer.parseInt(br.readLine());
            if (size == 1) {
                System.out.println("#1\n1");
                continue;
            }
            arr = new int[size + 1][size + 1];
            setStartPos();
            for (int j = 1; j < size; j++) {
                moveLine(j);
                turnLeft();
                moveLine(j);
                turnLeft();
                if (j == size - 1) {
                    moveLine(j);
                }
            }
            printSnail(i);
        }
    }

    static void setStartPos() {
        num = size * size;
        y = (size / 2) + 1;
        if (size % 2 == 0) {
            x = size / 2;
            direction = 0;
        } else {
            x = (size / 2) + 1;
            direction = 2;
        }
        arr[y][x] = num;
    }

    private static void moveLine(int j) {
        for (int k = 0; k < j; k++) {
            move();
        }
    }

    static void move() {
        num--;
        x += dx[direction];
        y += dy[direction];
        arr[y][x] = num;
    }

    static void turnLeft() {
        if (direction == 3) {
            direction = 0;
            return;
        }
        direction++;
    }

    private static void printSnail(int tCase) {
        StringBuilder sb = new StringBuilder();
        sb.append("#").append(tCase).append("\n");
        for (int j = 1; j <= size; j++) {
            for (int k = 1; k <= size; k++) {
                sb.append(arr[j][k]).append(" ");
            }
            if (j != size) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}