import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int studentNum = Integer.parseInt(br.readLine());
        Student[] students = new Student[studentNum];
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            students[i] = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (Student s : students) {
            if (s.sex == 1) {
                int index = s.num;
                while (index <= n) {
                    change(index);
                    index += s.num;
                }

            } else {
                int index = s.num;
                int count = 1;
                change(index);
                while ((index - count) > 0 && (index + count) <= n) {
                    if (arr[index - count] == arr[index + count]) {
                        change(index - count);
                        change(index + count);
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]);
            sb.append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static void change(int index) {
        if (arr[index] == 1) {
            arr[index] = 0;
        } else {
            arr[index] = 1;
        }
    }
}
class Student {
    int sex;
    int num;

    public Student(int sex, int num) {
        this.sex = sex;
        this.num = num;
    }
}