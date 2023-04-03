import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[][] adjMatrix;
    static Point[] nodes;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tCase = 1; tCase <= T; tCase++) {
            N = Integer.parseInt(br.readLine());
            nodes = new Point[N + 2];

            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                nodes[i] = new Point(x, y);
            }

            adjMatrix = new boolean[N + 2][N + 2];

            // 갈 수 있다면
            // 인접 행렬에 추가
            for (int i = 0; i < N + 2; i++) {
                for (int j = i + 1; j < N + 2; j++) {
                    if (getDist(nodes[i], nodes[j]) <= 1000) {
                        adjMatrix[i][j] = true;
                        adjMatrix[j][i] = true;
                    }
                }
            }

            floyd();
            if (adjMatrix[0][N + 1]) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    static int getDist(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    static void floyd() {
        for (int k = 0; k < N + 2; k++) {
            for (int i = 0; i < N + 2; i++) {
                for (int j = 0; j < N + 2; j++) {
                    if (adjMatrix[i][k] && adjMatrix[k][j]) {
                        adjMatrix[i][j] = true;
                    }
                }
            }
        }
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}