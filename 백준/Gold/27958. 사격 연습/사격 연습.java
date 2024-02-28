import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static Node[][] board;
    static Node[][] tmpBoard;
    static ArrayList<ArrayList<Integer>> per;
    static int N;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int ans = -1;

        board = new Node[N][N];
        tmpBoard = new Node[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = new Node(Integer.parseInt(st.nextToken()));
            }
        }

        int[] bullet = new int[K];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            bullet[i] = Integer.parseInt(st.nextToken());
        }

        int[] line = new int[N];
        for (int i = 0; i < N; i++) {
            line[i] = i;
        }
        int[] out = new int[K];

        boolean[] visited = new boolean[N];
        per = new ArrayList<>();

        getPermutation(line, N, K, 0, out);

        for (ArrayList<Integer> element : per) {
            init();
            int scoreSum = 0;
            int bulletIdx = 0;

            for (int shootingLine : element) {
                for (int i = 0; i < N; i++) {
                    if (tmpBoard[shootingLine][i].health == 0) {
                        continue;
                    }

                    if (tmpBoard[shootingLine][i].health >= 10) {
                        scoreSum += tmpBoard[shootingLine][i].health;
                        tmpBoard[shootingLine][i].health = 0;
                        break;
                    } else {
                        if (tmpBoard[shootingLine][i].health <= bullet[bulletIdx]) {
                            if (tmpBoard[shootingLine][i].isFragment) {
                                scoreSum += tmpBoard[shootingLine][i].health;
                            } else {
                                scoreSum += board[shootingLine][i].health;
                            }

                            for (int dir = 0; dir < 4; dir++) {
                                int ny = shootingLine + dy[dir];
                                int nx = i + dx[dir];

                                if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                                    continue;
                                }

                                if (tmpBoard[ny][nx].health == 0) {
                                    if (!tmpBoard[shootingLine][i].isFragment && board[shootingLine][i].health / 4 != 0) {
                                        tmpBoard[ny][nx].health = board[shootingLine][i].health / 4;
                                        tmpBoard[ny][nx].isFragment = true;
                                    } else {
                                        break;
                                    }
                                }
                            }

                            tmpBoard[shootingLine][i].health = 0;
                        } else {
                            tmpBoard[shootingLine][i].health -= bullet[bulletIdx];
                        }
                        break;
                    }
                }
                bulletIdx++;
            }

            ans = Math.max(ans, scoreSum);
        }

        System.out.println(ans);
    }

    public static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmpBoard[i][j] = new Node(board[i][j].health);
            }
        }
    }

    public static void getPermutation(int[] arr, int N, int R, int depth, int[] out) {
        if (depth == R) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int element : out) {
                result.add(element);
            }

            per.add(result);
            return;
        }

        for (int i = 0; i < N; i++) {
            out[depth] = arr[i];
            getPermutation(arr, N, R, depth + 1, out);
            out[depth] = 0;
        }
    }

    private static class Node {
        int health;
        boolean isFragment;

        Node(int health) {
            this.health = health;
            isFragment = false;
        }
    }
}