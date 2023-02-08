import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] bingo;
    static boolean[][] checked;
    static int[] numbers;
    static int bingoCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bingo = new int[6][6];
        checked = new boolean[6][6];
        numbers = new int[25];

        inputMethod(br);

        for (int i = 0; i < numbers.length; i++) {
            int row = numbers[i] / 5;
            int col = numbers[i] % 5;
            checked[bingo[row][col] / 10][bingo[row][col] % 10] = true;
            checkBingo(bingo[row][col] / 10, bingo[row][col] % 10);
            if (bingoCnt >= 3) {
                System.out.println(i + 1);
                return;
            }
        }

    }

    private static void checkBingo(int row, int col) {
        // 세로 빙고 확인
        int checkCnt = 0;
        for (int i = 1; i <= 5; i++) {
            if (checked[row][i]) {
                checkCnt++;
            }
        }
        if (checkCnt == 5) {
            bingoCnt++;
        }

        // 가로 빙고 확인
        checkCnt = 0;
        for (int i = 1; i <= 5; i++) {
            if (checked[i][col]) {
                checkCnt++;
            }
        }
        if (checkCnt == 5) {
            bingoCnt++;
        }
        checkCnt = 0;

        // 우하향 빙고 확인
        if (row == col) {
            for (int i = 1; i <= 5; i++) {
                if (checked[i][i]) {
                    checkCnt++;
                }
            }
            if (checkCnt == 5) {
                bingoCnt++;
            }
            checkCnt = 0;
        }

        //우상향 빙고 확인
        if ((row + col) == 6) {
            for (int i = 1; i <= 5; i++) {
                if (checked[i][6 - i]) {
                    checkCnt++;
                }
            }
            if (checkCnt == 5) {
                bingoCnt++;
            }
        }
    }

    private static void inputMethod(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                int row = num / 5;
                int col = num % 5;
                bingo[row][col] = i * 10 + j;
            }
        }
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                numbers[j + (i * 5)] = Integer.parseInt(st.nextToken());
            }
        }
    }

}