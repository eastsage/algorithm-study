import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int result = 0;

        int[] arr = new int[1000];
        for (int i = 123; i <= 987; i++) {
            String str = Integer.toString(i);

            if (str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2)
                || str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0') {
                arr[i] = -1;
            }
        }
        String strNum;
        int strike;
        int ball;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            strNum = st.nextToken();
            strike = Integer.parseInt(st.nextToken());
            ball = Integer.parseInt(st.nextToken());

            int strikeCnt = 0;
            int ballCnt = 0;

            for (int idx = 123; idx <= 987; idx++) {
                if (arr[idx] == -1)
                    continue;
                int passCnt = 0;
                strikeCnt = 0;
                String strIdx = Integer.toString(idx);
                for (int j = 0; j < 3; j++) {
                    if (strNum.charAt(j) == strIdx.charAt(j))
                        strikeCnt++;
                }

                ballCnt = 0;
                for (int p = 0; p < 3; p++) {
                    for (int q = 0; q < 3; q++) {
                        if ((strNum.charAt(p) == strIdx.charAt(q)) && (p != q)) {
                            ballCnt++;
                        }
                    }
                }
                if ((strike != strikeCnt) || ball != ballCnt) {
                    arr[idx] = -1;
                    continue;
                }

                if ((strike == strikeCnt) && (ball == ballCnt)) {
                    arr[idx]++;
                }
            }

        }

        for (int i = 123; i <= 987; i++) {

            if (arr[i] != -1 && arr[i] == N) {
                result++;
            }
        }
        System.out.println(result);
    }
}