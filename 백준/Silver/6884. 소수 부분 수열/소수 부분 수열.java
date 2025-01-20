import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1};
    static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[][] map;
    static int n, res;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            Integer ans = null;
            String ans2 = "";

            // 입력 처리
            String[] inputLine = br.readLine().split(" ");
            List<Integer> input = Arrays.stream(inputLine)
                    .skip(1) // 첫 번째 숫자 (개수) 제거
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            // 슬라이딩 윈도우를 이용한 계산
            for (int i = 2; i <= input.size(); i++) { // 연속해서 더할 개수
                int[] windowSum = new int[input.size() + 1];
                for (int j = 0; j < input.size(); j++) {
                    windowSum[j + 1] = windowSum[j] + input.get(j);
                }

                boolean breakFlag = false;
                for (int j = 0; j <= input.size() - i; j++) {
                    int sum = windowSum[j + i] - windowSum[j];
                    if (isPrime(sum) && sum >= 2) {
                        ans = i;
                        ans2 = input.subList(j, j + i).stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(" "));
                        breakFlag = true;
                        break;
                    }
                }

                if (breakFlag) {
                    break;
                }
            }

            if (ans == null) {
                sb.append("This sequence is anti-primed.\n");
            } else {
                sb.append("Shortest primed subsequence is length ").append(ans)
                        .append(": ").append(ans2).append("\n");
            }
        }
        System.out.println(sb);


    }
    public static boolean isPrime(int a) {
        if (a <= 1) return false;
        int sqrt = (int) Math.sqrt(a);
        for (int i = 2; i <= sqrt; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}