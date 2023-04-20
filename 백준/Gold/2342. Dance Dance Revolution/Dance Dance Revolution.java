import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * c -> all = 2 !c -> near = 3 !c -> reverse = 4
 */
public class Main {
    static int dp[][][];
    static int size;
    static List<Integer> steps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        steps = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while (true) {
            int to = Integer.parseInt(st.nextToken());
            if (to == 0) {
                break;
            }
            steps.add(to);
        }
        size = steps.size();
        dp = new int[size][5][5];
        int answer = process(0, 0, 0);
        System.out.println(answer);

    }

    static int process(int cnt, int l, int r) {
        if (cnt == size) {
            return 0;
        }
        if (dp[cnt][l][r] != 0) {    //이미 밟아본 발판일 경우
            return dp[cnt][l][r];
        }

        int nxt = steps.get(cnt);
        //process(idx+1, nxt, r) + width[l][nxt]) : 왼발로 다음 발판 밟기
        //process(idx+1, l, nxt) + width[r][nxt]) : 오른발로 다음 발판 밟기
        dp[cnt][l][r] = Math.min(
                process(cnt + 1, nxt, r) + getCost(l, nxt),
                process(cnt + 1, l, nxt) + getCost(r, nxt));

        return dp[cnt][l][r];
    }

    static int getCost(int from, int to) {
        int diff = Math.abs(from - to);
        if (from == 0) {
            return 2;
        } else if (diff == 1 || diff == 3) {
            return 3;
        } else if (diff == 2) {
            return 4;
        } else {
            return 1;
        }
    }
}