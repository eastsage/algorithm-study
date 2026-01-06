public class Main {
    private static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        private int read() throws java.io.IOException {
            if (ptr >= len) {
                len = System.in.read(buffer);
                ptr = 0;
                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }

        int nextInt() throws java.io.IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ' && c != -1);
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        if (n <= 0) {
            return;
        }

        int m = n - 1;
        int[] head = new int[n + 1];
        int[] to = new int[m * 2];
        int[] next = new int[m * 2];
        java.util.Arrays.fill(head, -1);
        int edgeIdx = 0;
        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            to[edgeIdx] = v;
            next[edgeIdx] = head[u];
            head[u] = edgeIdx++;
            to[edgeIdx] = u;
            next[edgeIdx] = head[v];
            head[v] = edgeIdx++;
        }

        int[] parent = new int[n + 1];
        int[] order = new int[n];
        int[] stack = new int[n];
        int sp = 0;
        int ordSize = 0;
        stack[sp++] = 1;
        parent[1] = 0;
        while (sp > 0) {
            int v = stack[--sp];
            order[ordSize++] = v;
            for (int e = head[v]; e != -1; e = next[e]) {
                int u = to[e];
                if (u == parent[v]) {
                    continue;
                }
                parent[u] = v;
                stack[sp++] = u;
            }
        }

        int[] size = new int[n + 1];
        for (int i = ordSize - 1; i >= 0; i--) {
            int v = order[i];
            int sum = 1;
            for (int e = head[v]; e != -1; e = next[e]) {
                int u = to[e];
                if (parent[u] == v) {
                    sum += size[u];
                }
            }
            size[v] = sum;
        }

        long total = (long) n * (n - 1);
        StringBuilder sb = new StringBuilder();
        for (int v = 1; v <= n; v++) {
            long excluded = 0;
            for (int e = head[v]; e != -1; e = next[e]) {
                int u = to[e];
                int c;
                if (parent[u] == v) {
                    c = size[u];
                } else if (parent[v] == u) {
                    c = n - size[v];
                } else {
                    continue;
                }
                excluded += (long) c * (c - 1);
            }
            long ans = total - excluded;
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}
