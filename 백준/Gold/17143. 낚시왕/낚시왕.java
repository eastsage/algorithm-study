import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 낚시왕이 오른쪽으로 한칸 이동
 * 2. 땅에서 가장 가까운 상어를 잡음 -> c 값이 가장 큰거
 * 3. 상어 이동
 *
 */
public class Main {
    static int R, C, M, fisher, result;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static Shark[][] sharks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sharks = new Shark[R + 1][C + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            if (d == 1) d = 0;
            if (d == 4) d = 1;
            if (d == 0 || d == 2) {
                s %= (R - 1) * 2;
            } else {
                s %= (C - 1) * 2;
            }
            sharks[r][c] = new Shark(r, c, s, d, z);
        } //input end
        while (++fisher <= C) {
            fishShark();
            moveShark();
        }
        System.out.println(result);
    }

    private static void moveShark() {
        Shark[][] tmp = new Shark[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                Shark shark = sharks[i][j];
                if (shark == null) continue;
                for (int k = 0; k < shark.s; k++) {
                    int nextR = shark.r + dy[shark.d];
                    int nextC = shark.c + dx[shark.d];

                    if (nextR <= 0 || nextR >= R + 1 || nextC <= 0 || nextC >= C + 1) {
                        shark.r -= dy[shark.d];
                        shark.c -= dx[shark.d];
                        shark.d = (shark.d + 2) % 4;
                        continue;
                    }
                    shark.r = nextR;
                    shark.c = nextC;
                }

                if (tmp[shark.r][shark.c] != null) {
                    if (tmp[shark.r][shark.c].z > shark.z) { //있던 놈이 크면 넘어감
                        continue;
                    }
                }
                tmp[shark.r][shark.c] = shark; // 칸이 비어있거나 신삥이 크면 넣어줌
            }
        }
        sharks = tmp;
    }

    private static void fishShark() {
        for (int i = 1; i <= R; i++) {
            if (sharks[i][fisher] != null) {
                result += sharks[i][fisher].z;
                sharks[i][fisher] = null;
                return;
            }
        }
    }
//    static void print() {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i <= R; i++) {
//            for (int j = 1; j <= C; j++) {
//                if (sharks[i][j] == null) {
//                    System.out.print("X ");
//                } else {
//                    sb.append(sharks[i][j].z);
//                    System.out.print("O ");
//                }
//            }
//            System.out.println();
//        }
//        System.out.println(sb);
//        System.out.println();
//    }
}

class Shark {
    int r, c, s, d, z;

    public Shark(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }
}