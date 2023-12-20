import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, m;
    static List<Integer>[] arr;
    static int[] bacons;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new List[n + 1];
        bacons = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            dijkstra(i);
        }

        // 최소 케빈 베이컨 수를 갖는 사람 찾기
        int minBacon = Integer.MAX_VALUE;
        int minBaconPerson = 1;
        for (int i = 1; i <= n; i++) {
            if (bacons[i] < minBacon) {
                minBacon = bacons[i];
                minBaconPerson = i;
            }
        }
        System.out.println(minBaconPerson);
    }

    static void dijkstra(int start) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> distance[i]));
        pq.add(start);

        while (!pq.isEmpty()) {
            int current = pq.poll();

            for (int next : arr[current]) {
                if (distance[next] > distance[current] + 1) {
                    distance[next] = distance[current] + 1;
                    pq.add(next);
                }
            }
        }

        // 케빈 베이컨 수 업데이트
        for (int i = 1; i <= n; i++) {
            bacons[start] += distance[i];
        }
    }
}