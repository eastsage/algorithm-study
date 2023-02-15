import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int max;
    static int start;
    static int[][] room;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tCase = 1; tCase <= T; tCase++) {
            N = Integer.parseInt(br.readLine());
            max = Integer.MIN_VALUE;
            room = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int tmp = bfs(j, k);
                    if (max < tmp) {
                        max = tmp;
                        start = room[j][k];
                    } else if (max == tmp) {
                        start = Math.min(start, room[j][k]);
                    }
                }
            }
            sb.append("#").append(tCase).append(" ").append(start).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        int cur = 0;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            cur++;
            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + tmp[0];
                int nextY = dy[i] + tmp[1];

                //범위를 넘어가거나, 1차이가 아닐 때 패스
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || room[tmp[0]][tmp[1]] + 1 != room[nextX][nextY]) {
                    continue;
                }
                q.add(new int[]{nextX, nextY});
            }
        }
        return cur;
    }

}