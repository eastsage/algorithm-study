import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[][] board, origin;
    static int result = 49;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[7][7];
        origin = new int[7][7];

        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                origin[i][j] = board[i][j];
            }
        }

        int ball = Integer.parseInt(br.readLine());
        for (int i = 0; i < 7; i++) {
            drop(ball, i);

            Set<List<Integer>> targets;
            Set<Integer> cols;
            while ((targets = findTargets()) != null) {
                cols = new HashSet<>();
                for (List<Integer> target : targets) {
                    board[target.get(0)][target.get(1)] = 0;
                    cols.add(target.get(1));
                }

                for (Integer col : cols) {
                    dropAfterDestroy(col);
                }
            }

            result = Math.min(result, count());
            
            if (result == 0) break;
            
            init();
        }

        System.out.println(result);
    }

    private static void drop(int ball, int y) {
        for (int i = 6; i > -1; i--) {
            if (board[i][y] == 0) {
                board[i][y] = ball;
                break;
            }
        }
    }

    private static Set<List<Integer>> findTargets() {
        Set<List<Integer>> targets = new HashSet<>();

        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {
                if (board[x][y] != 0) {
                    int hCnt = countHeight(x, y), wCnt = countWidth(x, y);

                    for (int i = x; i < 7; i++) {
                        if (board[i][y] == hCnt) {
                            targets.add(Arrays.asList(i, y));
                        } else if (board[i][y] == 0) {
                            break;
                        }
                    }

                    for (int i = x - 1; i > -1; i--) {
                        if (board[i][y] == hCnt) {
                            targets.add(Arrays.asList(i, y));
                        } else if (board[i][y] == 0) {
                            break;
                        }
                    }

                    for (int i = y; i < 7; i++) {
                        if (board[x][i] == wCnt) {
                            targets.add(Arrays.asList(x, i));
                        } else if (board[x][i] == 0) {
                            break;
                        }
                    }

                    for (int i = y - 1; i > -1; i--) {
                        if (board[x][i] == wCnt) {
                            targets.add(Arrays.asList(x, i));
                        } else if (board[x][i] == 0) {
                            break;
                        }
                    }
                }
            }
        }

        if (targets.size() == 0) {
            return null;
        }

        return targets;
    }

    private static int countHeight(int x, int y) {
        int hCnt = 0;

        for (int i = x; i < 7; i++) {
            if (board[i][y] != 0) {
                hCnt++;
            } else {
                break;
            }
        }

        for (int i = x - 1; i > -1; i--) {
            if (board[i][y] != 0) {
                hCnt++;
            } else {
                break;
            }
        }

        return hCnt;
    }

    private static int countWidth(int x, int y) {
        int wCnt = 0;

        for (int i = y; i < 7; i++) {
            if (board[x][i] != 0) {
                wCnt++;
            } else {
                break;
            }
        }

        for (int i = y - 1; i > -1; i--) {
            if (board[x][i] != 0) {
                wCnt++;
            } else {
                break;
            }
        }

        return wCnt;
    }

    private static void dropAfterDestroy(int y) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 6; i > -1; i--) {
            if (board[i][y] != 0) {
                numbers.add(board[i][y]);
                board[i][y] = 0;
            }
        }

        int i = 6;
        for (Integer number : numbers) {
            board[i--][y] = number;
        }
    }

    private static int count() {
        int cnt = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] != 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void init() {
        for (int i = 0; i < 7; i++) {
            board[i] = origin[i].clone();
        }
    }
}