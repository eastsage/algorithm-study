import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, result;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    static List<Pos> viruses = new ArrayList<>();
    static List<Pos> spaces = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 2) {
                    viruses.add(new Pos(i, j));
                } else if (input == 0) {
                    spaces.add(new Pos(i, j));
                }
                map[i][j] = input;
            }
        }

        comb(0, 0, new Pos[3]);
        System.out.println(result);
    }

    static void comb(int cnt, int start, Pos[] pick) {
        if (cnt == 3) {
            int[][] copiedMap = createMap(map, pick);
            result = Math.max(result, simulate(copiedMap));
            return;
        }
        for (int i = start; i < spaces.size(); i++) {
            pick[cnt] = spaces.get(i);
            comb(cnt + 1, i + 1, pick);
        }
    }

    static int simulate(int[][] map) {
        Queue<Pos> q = new ArrayDeque<>();
        for (Pos virus : viruses) {
            q.offer(virus);
        }
        while (!q.isEmpty()) {
            Pos tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] == 0) {
                    map[nx][ny] = 2;
                    q.offer(new Pos(nx, ny));
                }
            }
        }
//        show(map);
        return getSafetyArea(map); // safety area size
    }
    static int[][] createMap(int[][] map, Pos[] pick) {
        int[][] copiedMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copiedMap[i][j] = map[i][j];
            }
        }
        for (Pos pos : pick) {
            copiedMap[pos.x][pos.y] = 1;
        }
        return copiedMap;
    }

    static int getSafetyArea(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

//    static void show(int[][] map) {
//        for (int i = 0; i < N; i++) {
//            System.out.println();
//            for (int j = 0; j < M; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//        }
//    }
}

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}