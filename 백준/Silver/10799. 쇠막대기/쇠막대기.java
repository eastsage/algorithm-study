import java.util.*;

/**
 * count = 현재 위치에서 겹친 막대 수
 * @return ironBar = 잘린 막대 수
 * '('를 만나면 새로운 막대를 만났다고 가정하고 count++
 *
 * ')'를 만났을 때 고려할 것
 * 1-1. 바로 전이 '('일 경우 새로운 막대가 아닌 레이저'()'임으로 잘못더한 count--
 * 1-2. 레이저를 만나 막대가 잘렸으므로 ironBar += count
 *
 * 2-1 바로 전이 ')'일 경우 막대의 끝을 의미하므로 겹친 막대의 수 - 1 -> count--
 * 2-2 막대 하나가 끝났으므로 잘린 막대 + 1 -> ironBar++
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] chars = s.toCharArray();
        int count = 0;
        int ironBar = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                count++;
            } else { // if (char[i] == ')')
                count--;
                if (chars[i - 1] == '(') {
                    ironBar += count;
                } else { // if (chars[i - 1] == ')')
                    ironBar++;
                }
            }
        }
        System.out.println(ironBar);
    }
}
