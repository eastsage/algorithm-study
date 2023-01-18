import java.io.InputStreamReader;
 
import java.io.BufferedReader;
import java.io.IOException;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c_arr = br.readLine().toCharArray();
        int flag = 3;
        
        if(c_arr[0] < 97 || c_arr[0] > 122) {
            // 첫 문자 검사 : 소문자가 아니면 Error!
            flag = 0;
        } else {            
            // 두 번째 문자부터 검사
            for(int i = 1; i < c_arr.length; i++) {
                char c = c_arr[i];
                if(c == 95) {
                    // _
                    if(flag == 1) {
                        // JAVA인데 _ 나오면 에러
                        flag = 0;
                        break;
                    } else {
                        // JAVA가 아닌데 에러인 경우
                        // 마지막에 언더바
                        if(i == c_arr.length - 1) {
                            flag = 0;
                            break;
                        }
                        // 언더바 연속
                        else if(c_arr[i+1] == '_') {
                            flag = 0;
                            break;
                        } else {
                            flag = 2;
                        }
                    }
                } else if(c >= 65 && c <= 90) {
                    // 대문자
                    if(flag == 2) {
                        // C++인데 대문자 나오면 에러
                        flag = 0;
                        break;
                    } else {
                        // 언어 안정해졌으면 JAVA로 설정
                        flag = 1;
                    }
                }
            }
        }
        
        // 에러
        if(flag == 0) {
            System.out.println("Error!");
        } else if(flag == 1) {
            convertToC(c_arr);
        } else if(flag == 2) {
            convertToJava(c_arr);
        } else {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < c_arr.length; i++) {
                sb.append(c_arr[i]);
            }
            System.out.println(sb.toString());
        }
        
        return;
    }
 
    private static void convertToJava(char[] c_arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < c_arr.length; i++) {
            char c = c_arr[i];
            if(c == 95) {
                i++;
                sb.append((char)(c_arr[i] - 32));
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
        return;
    }
 
    private static void convertToC(char[] c_arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < c_arr.length; i++) {
            char c = c_arr[i];
            if(c >= 65 && c <= 90) {
                sb.append('_');
                sb.append((char)(c + 32));
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
        return;
    }
}