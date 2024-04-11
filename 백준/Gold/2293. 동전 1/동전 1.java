import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n, k, t, w, result;
    static int[] dp;
    static int[] arr;
    static boolean[] visited;
    static int[] dx = {-1, -0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n + 1];
        int[] cnt = new int[k + 1];
        cnt[0] = 1;

        for (int i = 1; i <= n; i++)
            coin[i] = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            for (int j = coin[0]; j <= k; j++) {
                if (j < coin[i])
                    continue;

                cnt[j] += cnt[j - coin[i]];
            }
        }

        System.out.println(cnt[k]);
    }
}