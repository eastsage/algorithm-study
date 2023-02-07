import java.util.Arrays;
import java.util.Scanner;

//nPr
//N개 중에 R개를 뽑아 순서있게 늘어 놓기
public class Main {
    static int N, R, totalCount;
    static int[] result, numbers; //result: 순열로 뽑힌 숫자들이 있는 배열 numbers: 전체 데이터 배열
    static boolean[] isSelected; // 이미 뽑힌숫자 체크

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();

        numbers = new int[N];
        result = new int[R];
        isSelected = new boolean[N];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        perm(0);
//        System.out.println("총 경우의 수: " + totalCount);
    }

    //현재까지 뽑힌 숫자 개수를 입력받아 체크 한 뒤 종료하거나 숫자를 뽑거나 함
    //cnt: 이제까지 뽑은 순열을 구성하는 숫자 개수
    private static void perm(int cnt) {
        if (cnt == R) {
            totalCount++;
            System.out.println(toString(result));
            return;
        }
        for (int i = 0; i < isSelected.length; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                result[cnt] = numbers[i]; // i번째 값을 선택

                perm(cnt + 1); // 다음숫자 뽑기
                isSelected[i] = false;
            }
        }
    }
    public static String toString(int[] a) {
        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "";

        StringBuilder b = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            b.append(a[i]);
            b.append(" ");
        }
        return b.toString();
    }
}