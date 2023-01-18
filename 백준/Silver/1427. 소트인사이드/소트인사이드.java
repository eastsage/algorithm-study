import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] split = s.split("");
        Arrays.sort(split, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String str : split) {
            sb.append(str);
        }
        System.out.println(sb);
    }
}