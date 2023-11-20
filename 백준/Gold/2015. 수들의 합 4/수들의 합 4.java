import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static long cnt;
    static long[] prefixSum;
    static Map<Long, List> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        prefixSum = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = Long.parseLong(st.nextToken()) + prefixSum[i - 1];
            if (prefixSum[i] == k) {
                cnt++;
            }

            if (map.containsKey(prefixSum[i] - k)) {
                cnt += map.get(prefixSum[i] - k).size();
            }
            if (map.containsKey(prefixSum[i])) {
                map.get(prefixSum[i]).add(i);
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                map.put(prefixSum[i], tmp);
            }

//            System.out.println(map);
//            System.out.println(cnt);
        }
        System.out.println(cnt);
    }
}