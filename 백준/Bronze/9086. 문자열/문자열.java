import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        int a = sc.nextInt();
        for (int i = 0; i < a; i++) {
            String text = sc.next();
            String arr[] = text.split("");

            list.add(arr[0]);
            list.add(arr[arr.length - 1]);
        }
        for (int i = 0; i < list.size(); i+=2) {
            System.out.println(list.get(i)+list.get(i+1));
        }
    }
}