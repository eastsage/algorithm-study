import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int n, m, result;
    static Set<Integer>[] edges;
    static List<Section> sections = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        sections.add(new Section(0, 0));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (command == 1) {
                sections.add(new Section(a, b));
            } else {
                if (search(a, b)) {
                    System.out.println(("1"));
                } else {
                    System.out.println(("0"));
                }
            }
        }
    }

    static boolean search(int s, int e) {
        Queue<Section> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        visited[s] = true;
        q.add(sections.get(s));
        while (!q.isEmpty()) {
            Section cur = q.poll();
            if (cur.x == sections.get(e).x && cur.y == sections.get(e).y) {
                return true;
            }
            for (int i = 1; i < sections.size(); i++) {
                Section info = sections.get(i);
                if (!visited[i] && (check(info, cur.x) || check(info, cur.y))) {
                    visited[i] = true;
                    q.add(info);
                }
            }
        }
        return false;
    }

    static boolean check(Section nxt, int val) {
        if (val > nxt.x && val < nxt.y) {
            return true;
        }
        return false;
    }

    private static class Section {
        int x;
        int y;

        public Section(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}