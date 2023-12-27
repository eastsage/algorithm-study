import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>(9);
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            list.add(Integer.parseInt(br.readLine()));
            sum += list.get(i);
        }
        Collections.sort(list);
        int s = 0, e = 8;

        while (s <= e) {
            if (sum - list.get(s) - list.get(e) < 100) {
                e--;
            } else if (sum - list.get(s) - list.get(e) > 100) {
                s++;
            } else {
                list.remove(e);
                list.remove(s);
                break;
            }
        }
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}