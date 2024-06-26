import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] s, e;
    static int[][] arr;
    static char[][][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input>0) {
                pq.add(input);
            } else {
                if (!pq.isEmpty()) {
                    System.out.println(pq.poll());
                }
                else{
                    System.out.println(0);
                }
            }
        }
    }
}