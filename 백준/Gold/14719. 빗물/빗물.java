import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] map;
    static int sum;

    public static void main(String[] args) throws IOException {
        input();

        // 현재 idx에서 왼쪽에서 peek 오른쪽에서 peek를 찾고
        // 그 중에서 작은놈 - 본인 == 물의 양
        // 양 끝은 안됨

        for (int i = 1; i < map.length - 1; i++) {
            int lPeek = 0;
            int rPeek = 0;

            for (int j = i - 1; j >= 0; j--) {
                lPeek = Math.max(lPeek, map[j]);
            }

            for (int j = i + 1; j < map.length; j++) {
                rPeek = Math.max(rPeek, map[j]);
            }

            if (map[i] < lPeek && map[i] < rPeek) {
                sum += Math.min(lPeek, rPeek) - map[i]; // 더 낮은 봉우리 만큼 물이 고임
            }
        }
        System.out.println(sum);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        st.nextToken(); // height 필요 없음
        int width = Integer.parseInt(st.nextToken());
        map = new int[width];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < map.length; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
    }
}