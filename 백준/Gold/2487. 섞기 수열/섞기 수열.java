import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int n, result;
    static int[] m;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = new int[n + 1];
        visited = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }
        result = 1;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            result = lcm(result, getCycleCnt(i));
        }
        System.out.println(result);
    }
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
    static int getCycleCnt(int s) {
        int cycleCnt = 1;
        int next = m[s];

        while (true) {
            if (s == next) {
                return cycleCnt;
            }
            visited[next] = true;
            next = m[next];
            cycleCnt++;
        }
    }
}