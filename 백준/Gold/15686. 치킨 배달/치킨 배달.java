import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static List<Matrix> BBQ;
    static int minChickenDistanceOfCity;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        BBQ = new ArrayList<>();
        minChickenDistanceOfCity = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 2) {
                    BBQ.add(new Matrix(i, j));
                }
                map[i][j] = input;
            }
        }
        Matrix[] survive = new Matrix[M];
        combi(survive, 0, 0);
        System.out.println(minChickenDistanceOfCity);
    }

    static void combi(Matrix[] survive, int cnt, int start) {
        if (cnt == M) {
            calChickenDistance(survive);
            return;
        }

        for (int i = start; i < BBQ.size(); i++) {
            survive[cnt] = BBQ.get(i);
            combi(survive, cnt + 1, i + 1);
        }
    }
    static void calChickenDistance(Matrix[] survive) {
        int chickenDistanceOfCity = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1) {
                    int chickenDist = Integer.MAX_VALUE;
                    for (Matrix m : survive) {
                        chickenDist = Math.min(chickenDist, Math.abs(m.row - i) + Math.abs(m.col - j));
                    }
                    chickenDistanceOfCity += chickenDist;
                }
            }
        }
        minChickenDistanceOfCity = Math.min(minChickenDistanceOfCity, chickenDistanceOfCity);
    }
}

class Matrix {
    int row;
    int col;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
    }
}