import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] checker;
    static int[][] candidate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        checker = new int[n][2];
        Set<Integer> tmpX = new HashSet<>();
        Set<Integer> tmpY = new HashSet<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            checker[i][0] = x;
            checker[i][1] = y;
            tmpX.add(x);
            tmpY.add(y);
        }
        candidate = new int[tmpX.size() * tmpY.size()][2];
        int num = 0;
        for (Integer x : tmpX) {
            for (Integer y : tmpY) {
                candidate[num][0] = x;
                candidate[num++][1] = y;
            }
        }

        int[][] accumulatedDist = new int[candidate.length][n];
        for (int i = 0; i < candidate.length; i++) {
            int[] tmp = new int[n];
            for (int j = 0; j < n; j++) {
                tmp[j] = getDist(candidate[i], checker[j]);
            }
            Arrays.sort(tmp);
            for (int j = 1; j < n; j++) {
                tmp[j] += tmp[j - 1];
            }
            accumulatedDist[i] = tmp;
        }

        StringBuilder sb = new StringBuilder("0 ");
        for (int j = 1; j < n; j++) {
            int min = 2_000_000_000;
            for (int i = 0; i < accumulatedDist.length; i++) {
                min = Math.min(min, accumulatedDist[i][j]);
            }
            sb.append(min + " ");
        }
        System.out.print(sb.substring(0, sb.length() - 1));
    }

    static int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}