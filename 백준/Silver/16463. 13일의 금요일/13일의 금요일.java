import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final long INF = Long.MAX_VALUE / 2;
    static int n, m, a, b;
    static int[] arr;
    static int[][] map;
    static int[][][][] dp;
    static boolean[] visible;
    static List<long[]>[] edges;

    public static void main(String[] args) throws IOException {
        init();
        int count = 0;
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int firstDay = 1;
        int friday = 4;

        for (int year = 2019; year <= n; year++) {
            for (int month = 1; month <= 12; month++) {
                // 해당 달 13일의 요일: (첫 날 요일 + 12) mod 7
                int dayOf13th = (firstDay + 12) % 7;
                if (dayOf13th == friday) {
                    count++;
                }

                // 이번 달의 일수 (2월인 경우 윤년 체크)
                int days = daysInMonth[month];
                if (month == 2 && isLeapYear(year)) {
                    days = 29;
                }
                // 다음 달의 첫 날 요일 갱신
                firstDay = (firstDay + days) % 7;
            }
        }

        System.out.println(count);
    }

    static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
    }
}