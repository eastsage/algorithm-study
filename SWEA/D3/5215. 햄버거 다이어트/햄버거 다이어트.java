import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    static int N, L;
    static int[] scores;
    static int[] calories;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            max = 0;
            scores = new int[N];
            calories = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                scores[i] = Integer.parseInt(st.nextToken());
                calories[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= N; i++) {
                combi(i, 0, 0, 0, 0);
            }
            System.out.println("#" + test_case + " " + max);
        }
    }

    static void combi(int amount, int cnt, int start, int calSum, int scoreSum) {
        max = Math.max(max, scoreSum);
        if (cnt == amount) {
//            if (calSum <= L) {
//
//            }
            return;
        }

        for (int j = start; j < N; j++) {
            if (calSum + calories[j] > L) {
                continue;
            }
            combi(amount, cnt + 1, j + 1, calSum + calories[j], scoreSum + scores[j]);
        }
    }
}