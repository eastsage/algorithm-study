import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static final int INF = 1_000_000_000;
    static int[][] dist;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        int T = Integer.parseInt(br.readLine());

        for (int tCase = 1; tCase <= T; tCase++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Integer.parseInt(st.nextToken());
                    if (i != j && dist[i][j] == 0) {
                        dist[i][j] = INF;
                    }
                }
            } //input end

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    if (k == i) continue;
                    for (int j = 0; j < N; j++) {
                        if (k == j || i == j) continue;
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            } //dist 완성
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;

                    sum += dist[i][j];
                }
                result = Math.min(result, sum);
            }

            sb = new StringBuilder();
            sb.append("#").append(tCase).append(" ").append(result);
            System.out.println(sb);
        }
    }
}