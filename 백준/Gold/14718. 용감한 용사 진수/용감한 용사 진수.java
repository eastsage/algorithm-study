import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N, K, m, cnt;
    static int[] dp;
    static int[][] stats;
    static List<int[]> aList = new ArrayList<>();
    static boolean[] visited;
    static int[] dx = {0, 1, -1, 0, 1, 1, -1, -1};
    static int[] dy = {1, 0, 0, -1, 1, -1, 1, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stats = new int[N][3];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stats[i][0] = Integer.parseInt(st.nextToken());
            stats[i][1] = Integer.parseInt(st.nextToken());
            stats[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int cnt = 0;

                    for (int n = 0; n < N; n++) {
                        if (stats[i][0] >= stats[n][0] && stats[j][1] >= stats[n][1] && stats[k][2] >= stats[n][2]) {
                            cnt++;
                        }
                    }

                    if (cnt >= K) min = Math.min(min, stats[i][0] + stats[j][1] + stats[k][2]);
                }
            }
        }

        System.out.println(min);
    }
}