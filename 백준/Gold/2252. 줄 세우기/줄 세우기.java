import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static Node[] adjList; //인접 리스트
    static int[] inDegree; //진입 차수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new Node[N + 1];
        inDegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, adjList[from]);
            inDegree[to]++;
        }
        ArrayList<Integer> students = topologySort();
        for (Integer student : students) {
            System.out.print(student + " ");
        }

    }

    static ArrayList<Integer> topologySort() {
        ArrayList<Integer> students = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }// 진입 차수가 0이면 넣기
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            students.add(cur);
            for (Node tmp = adjList[cur]; tmp != null; tmp = tmp.link) {
                if (--inDegree[tmp.vertex] == 0) {
                    q.offer(tmp.vertex);
                }
            }
        }
        return students;
    }
}

class Node {
    int vertex;
    Node link;

    public Node(int vertex, Node link) {
        this.vertex = vertex;
        this.link = link;
    }
}