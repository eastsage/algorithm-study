import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    static int node[][];
    static int check[];

    static void bfs(int start) { // BFS 메소드
        Queue<Integer> queue = new LinkedList<>();

        check[start] = 1;
        queue.offer(start);
        int cnt = 0; // 감염 된 컴퓨터의 수
        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int i = 1; i < node.length; i++) {
                if (node[x][i] == 1 && check[i] != 1) {
                    queue.offer(i);
                    check[i] = 1;
                    cnt++;
                }
            }
        }
        System.out.println(cnt); //모든 탐색을 마치고 cnt 출력
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 컴퓨터의 수
        int m = sc.nextInt(); // 네트워크 상에 연결되어 있는 컴퓨터 쌍의 수 즉, 간선의 수
        node = new int[n + 1][n + 1];
        check = new int[n + 1];
        for (int i = 0; i < m; i++) { // 그래프 구성
            int a = sc.nextInt();
            int b = sc.nextInt();
            node[a][b] = 1;
            node[b][a] = 1;
        }
        bfs(1);
    }
}