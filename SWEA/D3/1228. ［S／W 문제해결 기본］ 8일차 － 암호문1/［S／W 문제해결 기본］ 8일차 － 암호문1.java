import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tCase = 1; tCase <= 10; tCase++) {
            int len = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new LinkedList<>();

            for (int i = 0; i < len; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                if (st.nextToken().equals("I")) {
                    int index = Integer.parseInt(st.nextToken());
                    int num = Integer.parseInt(st.nextToken());

                    for (int i = 0; i < num; i++) {
                        list.add(index++, Integer.parseInt(st.nextToken()));
                    }
                }
            }
            sb.append("#").append(tCase).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}