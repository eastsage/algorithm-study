import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, root, depth;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            root = 0;
            depth = 0;
            N = Integer.parseInt(br.readLine());
            parent = new int[N + 1];
            boolean[] tmp = new boolean[N + 1];
            for (int j = 1; j <= N - 1; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                tmp[b] = true;
                parent[b] = a;
            }
            for (int j = 1; j <= N; j++) {
                if (!tmp[j]) { // 자식으로 나온 적 없는 놈이 루트
                    root = j;
                    parent[j]=j;
                    break;
                }
            }

            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            getDepth(node1);
            int depth1 = depth;

            depth = 0;
            getDepth(node2);
            int depth2 = depth;

            while (depth1 != depth2) {
                if (depth1 > depth2) {
                    node1 = parent[node1];
                    depth1--;
                } else {
                    node2 = parent[node2];
                    depth2--;
                }
            }
            depth = depth1;

            int commonParent = findCommonParent(node1, node2);
            System.out.println(commonParent);
        }
    }

    static int findCommonParent(int node1, int node2) {
        if (node1 == node2) {
            return node1;
        }
        if (parent[node1] == parent[node2]) {
            return parent[node1];
        }
        while (depth-- != 0) {
            if (parent[node1] == parent[node2]) {
                return parent[node1];
            } else {
                node1 = parent[node1];
                node2 = parent[node2];
            }
        }
        return -1;
    }

    static void getDepth(int a) {
        depth++;
        if (parent[a] != root) {
            getDepth(parent[a]);
        }
    }
}