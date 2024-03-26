import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, d;
    static int[] arr, dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        Map<String, Node> nodes = new HashMap<>();
        nodes.put("A", new Node("A"));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String v = st.nextToken();
            String l = st.nextToken();
            String r = st.nextToken();
            Node parent = nodes.get(v);
            if (!l.equals(".")) {
                parent.l = new Node(l);
                nodes.put(l, parent.l);
            }
            if (!r.equals(".")) {
                parent.r = new Node(r);
                nodes.put(r, parent.r);
            }
        }
        Node root = nodes.get("A");
        preorder(root);
        sb.append("\n");
        inorder(root);
        sb.append("\n");
        postorder(root);
        System.out.println(sb);

    }
    static void preorder(Node node) {
        if (node == null) return;
        sb.append(node.v);
        preorder(node.l);
        preorder(node.r);
    }

    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.l);
        sb.append(node.v);
        inorder(node.r);
    }

    static void postorder(Node node) {
        if (node == null) return;
        postorder(node.l);
        postorder(node.r);
        sb.append(node.v);
    }

    private static class Node {
        String v;
        Node l, r;

        public Node(String v) {
            this.v = v;
        }
    }
}