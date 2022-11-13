package algorithm.stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ClawMachineGame {
    public static int solution(int[][] arr, int[] moves) {
        int answer = 0;
        int picked = 0;
        List<Stack<Integer>> board = new ArrayList<>();
        Stack<Integer> basket = new Stack<>();
        for (int j = 0; j < arr.length; j++) {
            board.add(new Stack<Integer>());
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i][j] != 0) {
                    board.get(j).push(arr[i][j]);
                }
            }
        }

        for (int move : moves) {
            if (!board.get(move - 1).isEmpty()) {
                picked = board.get(move - 1).pop();
                if (basket.isEmpty()) {
                    basket.push(picked);
                } else if (basket.peek() == picked) {
                    basket.pop();
                    answer += 2;
                } else {
                    basket.push(picked);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int input[] = new int[m];
        for (int i = 0; i < m; i++) {
            input[i] = sc.nextInt();
        }
        System.out.println(solution(arr, input));
    }
}
