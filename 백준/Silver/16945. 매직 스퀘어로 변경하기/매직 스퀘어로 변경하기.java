import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int n, m, cnt, result;
    static int[] dp;
    static int[][] arr, map, MS;
    static List<int[]> aList = new ArrayList<>();
    static boolean[] visited;
    static int[] dx = {0, 1, -1, 0, 1, 1, -1, -1};
    static int[] dy = {1, 0, 0, -1, 1, -1, 1, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[3][3];
        MS = new int[3][3];
        visited = new boolean[10];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = Integer.MAX_VALUE;
        recur(0);
        System.out.println(result);
    }

    /**
     * make square (9!)
     * is MS?
     * get Dist
     * update Min
     */
    static void recur(int cnt) {
        if (cnt == 9 && isMS()) {
            int dist = getDist();
            result = Math.min(result, dist);
        }
        int x = cnt / 3;
        int y = cnt % 3;
        for (int i = 1; i <= 9; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            MS[x][y] = i;
            recur(cnt + 1);
            visited[i] = false;
        }
    }

    static int getDist() {
        int dist = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dist += Math.abs(arr[i][j] - MS[i][j]);
            }
        }
        return dist;
    }

    static boolean isMS() {
        int rowSum0 = MS[0][0] + MS[0][1] + MS[0][2];
        int rowSum1 = MS[1][0] + MS[1][1] + MS[1][2];
        int rowSum2 = MS[2][0] + MS[2][1] + MS[2][2];

        int colSum0 = MS[0][0] + MS[1][0] + MS[2][0];
        int colSum1 = MS[0][1] + MS[1][1] + MS[2][1];
        int colSum2 = MS[0][2] + MS[1][2] + MS[2][2];

        int diagonalSum0 = MS[0][0] + MS[1][1] + MS[2][2];
        int diagonalSum1 = MS[2][0] + MS[1][1] + MS[0][2];

        if (rowSum0 != 15 || rowSum1 != 15 || rowSum2 != 15) return false;
        if (colSum0 != 15 || colSum1 != 15 || colSum2 != 15) return false;
        if (diagonalSum0 != 15 || diagonalSum1 != 15) return false;

        return true;
    }
}