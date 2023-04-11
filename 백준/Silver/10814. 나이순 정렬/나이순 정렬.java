import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<User> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new User(num, name));
        }
        Collections.sort(list);

        for (User user : list) {
            System.out.println(user);
        }
    }

    private static class User implements Comparable<User> {
        int num;
        String name;

        public User(int num, String name) {
            this.num = num;
            this.name = name;
        }

        @Override
        public String toString() {
            return num + " " + name;
        }

        @Override
        public int compareTo(User o) {
            if (this.num == o.num) {
                return 0;
            }
            return this.num - o.num;
        }
    }
}