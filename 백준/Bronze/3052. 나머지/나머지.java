
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt() % 42;
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int checkData : arr) {
            if (!list.contains(checkData)) {
                list.add(checkData);
            }
        }
        
        int [] newArr = new int [list.size()];
        for (int i = 0; i < newArr.length; i++)
            newArr[i] = list.get(i);
        System.out.println(newArr.length);
    }
}
