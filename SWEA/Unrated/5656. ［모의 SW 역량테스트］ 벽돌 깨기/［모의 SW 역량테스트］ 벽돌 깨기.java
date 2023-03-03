import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int n, w, h, min;
    static int[][] bricks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tCase = 1; tCase <= T; tCase++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;

            bricks = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    bricks[i][j] = Integer.parseInt(st.nextToken());
                }
            } // input end

            dfs(0, bricks);
            System.out.println("#" + tCase + " " + min);
        }
    }

    static void dfs(int depth, int[][] bricks) {
        int amount = getBricksAmount(bricks);
        if (depth == n || amount == 0) {
            min = Math.min(min, amount);
            return;
        }
        for (int i = 0; i < w; i++) {
            int[][] nextBricks = deepCopy(bricks);
            int x = getTarget(i, nextBricks);
            int y = i;

            if (x != -1) {
                destroy(x, y, nextBricks);
                drop(nextBricks);
            }
            dfs(depth + 1, nextBricks);
        }
    }

    static int getTarget(int y, int[][] bricks) {
        for (int i = 0; i < h; i++) {
            if (bricks[i][y] != 0) {
                return i;
            }
        }
        return -1;
    }

    static void destroy(int x, int y, int[][] bricks) {
        int val = bricks[x][y];
        bricks[x][y] = 0;
        for (int i = 1; i < val; i++) {
            if (y + i < w && bricks[x][y + i] > 1) {
                destroy(x, y + i, bricks);
            } else if (y + i < w) {
                bricks[x][y + i] = 0;
            }

            if (y - i >= 0 && bricks[x][y - i] > 1) {
                destroy(x, y - i, bricks);
            } else if (y - i >= 0) {
                bricks[x][y - i] = 0;
            }

            if (x + i < h && bricks[x + i][y] > 1) {
                destroy(x + i, y, bricks);
            } else if (x + i < h) {
                bricks[x + i][y] = 0;
            }

            if (x - i >= 0 && bricks[x - i][y] > 1) {
                destroy(x - i, y, bricks);
            } else if (x - i >= 0) {
                bricks[x - i][y] = 0;
            }
        }
    }

    static void drop(int[][] bricks) {
        for (int i = 0; i < w; i++) {
            int[] tmp1 = new int[h];
            for (int j = 0; j < h; j++) {
                tmp1[j] = bricks[j][i];
                bricks[j][i] = 0;
            }
            int[] tmp2 = Arrays.stream(tmp1).filter(num -> num > 0).toArray();
            for (int j = 0; j < tmp2.length; j++) {
                bricks[h - tmp2.length + j][i] = tmp2[j];
            }
        }
    }

    static int getBricksAmount(int[][] bricks) {
        int cnt = 0;
        for (int i = 0; i < w; i++) {
            for (int j = h - 1; j >= 0; j--) {
                if (bricks[j][i] != 0) {
                    cnt++;
                } else {
                    break;
                }
            }
        }
        return cnt;
    }

    static int[][] deepCopy(int[][] bricks) {
        int[][] copied = new int[h][w];
        for (int i = 0; i < h; i++) {
            copied[i] = bricks[i].clone();
        }
        return copied;
    }
//    static void print(int[][] bricks) {
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                System.out.print(bricks[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

}