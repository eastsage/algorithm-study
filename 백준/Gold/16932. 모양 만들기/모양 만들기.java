import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, areaKey;
    static int[] dx = {1, -1, 0, 0};//down, up
    static int[] dy = {0, 0, 1, -1};//right, left
    static boolean[][] visited;
    static boolean[][] map;
    static int[][] newMap;
    static Map<Integer, Integer> area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        area = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];
        newMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if (st.nextToken().equals("1")) {
                    map[i][j] = true;
                }
            }
        } //input end

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j]) {
                    ++areaKey;
                    makeNewMapByBfs(new Pos(i, j));
                }
            }
        }
        System.out.println(getResult());
    }


    static int getResult() {
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (newMap[i][j] != 0) continue;
                int tmp = 0;
                Set<Integer> keySet = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                    int element = newMap[nx][ny];
                    if (element == 0) continue;
                    keySet.add(element);
                }
                for(Integer k : keySet){
                    tmp+=area.get(k);
                }
                result = Math.max(result, tmp);
            }
        }
        return result + 1;
    }

    static void makeNewMapByBfs(Pos pos) {
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(pos);
        visited[pos.x][pos.y] = true;
        int areaValue = 0;

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            areaValue++;
            newMap[cur.x][cur.y] = areaKey;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (!visited[nx][ny] && map[nx][ny]) {
                    q.offer(new Pos(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        area.put(areaKey, areaValue);
    }
}

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}