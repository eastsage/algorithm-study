import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] paper = new boolean[100][100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int leftMargin = Integer.parseInt(st.nextToken());
            int bottomMargin = Integer.parseInt(st.nextToken());

            for (int j = bottomMargin; j < bottomMargin + 10; j++) {
                for (int k = leftMargin; k < leftMargin + 10; k++) {
                    if (!paper[j][k]) {
                        paper[j][k] = true;
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}