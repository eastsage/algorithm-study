import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        List<String> list = new ArrayList<String>(set);
        Collections.sort(list, (o1, o2) -> {
            if (o1.length()==o2.length()){
                return o1.compareTo(o2);
            }
            else if (o1.length() > o2.length()) {
                return 1;
            } else {
                return -1;
            }
        });

        for (String s : list) {
            System.out.println(s);
        }

    }
}