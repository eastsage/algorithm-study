package algorithm.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SavePrincess {
    public static int solution(int size, int target) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            queue.add(i + 1);
        }
        while (queue.size() != 1) {
            count++;
            Integer poll = queue.poll();
            if (count % target != 0) {
                queue.add(poll);
            }
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(solution(a, b));
    }
}
