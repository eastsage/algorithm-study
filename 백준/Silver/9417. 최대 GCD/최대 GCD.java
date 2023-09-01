import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int max;
    static List<Integer> numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            numbers = new ArrayList<>();
            max = 0;
            while (st.hasMoreTokens()) {
                numbers.add(Integer.parseInt(st.nextToken()));
            }

            comb(0, new ArrayList<>());

            System.out.println(max);
        }
    }

    static int euclid(int a, int b) {
        if (b == 0) {
            return a;
        }
        return euclid(b, a % b);
    }

    static void comb(int start, List<Integer> list) {
        if (list.size() == 2) {
            int gcd = euclid(list.get(1), list.get(0));
//            System.out.println(list);
            max = Math.max(max, gcd);
            return;
        }

        if (start >= numbers.size()) return;

        // 현재 요소를 포함하지 않고 조합 생성
        comb(start + 1, list);

        // 현재 요소를 포함하고 조합 생성
        list.add(numbers.get(start));
        comb(start + 1, list);

        // 원상태로 되돌림
        list.remove(list.size() - 1);
    }
}