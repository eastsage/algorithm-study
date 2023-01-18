import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int count = 0;
        s = s.replace("ce", "q");
        s = s.replace("c-", "q");
        s = s.replace("dz=", "q");
        s = s.replace("d-", "q");
        s = s.replace("lj", "q");
        s = s.replace("nj", "q");
        s = s.replace("s=", "q");
        s = s.replace("z=", "q");
        

        for (int i = 0; i < s.length(); i++) {
            if (97<=s.charAt(i) && s.charAt(i)<=122)
                count++;
        }
        System.out.println(count);
    }
}
