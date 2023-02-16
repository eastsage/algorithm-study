import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static City[] cities;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        cities = new City[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MIN_VALUE);
        for (int i = 1; i <= N; i++) {
            cities[i] = new City(i, new ArrayList<>());
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            cities[Integer.parseInt(st.nextToken())].nearCities.add(Integer.parseInt(st.nextToken()));
        }
        bfs();
    }
    static void bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(X);
        distance[X] = 0;

        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int i = 0; i < cities[tmp].nearCities.size(); i++) {
                Integer next = cities[tmp].nearCities.get(i);
                if (distance[next] == Integer.MIN_VALUE) {
                    distance[next] = distance[tmp] + 1;
                    q.offer(next);
                }
            }
        }
        boolean founded = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                founded = true;
            }
        }
        if (!founded) {
            System.out.println(-1);
        }
    }
}

class City {
    int num;
    List<Integer> nearCities;

    public City(int num, List<Integer> nearCities) {
        this.num = num;
        this.nearCities = nearCities;
    }
}