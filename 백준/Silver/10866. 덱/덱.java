import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[100_000];
    static int n, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[100_000];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s) {
                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;

                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    sb.append(pop_front()).append("\n");
                    break;

                case "pop_back":
                    sb.append(pop_back()).append("\n");
                    break;

                case "size":
                    sb.append(size()).append("\n");
                    break;

                case "empty":
                    sb.append(empty()).append("\n");
                    break;

                case "front":
                    sb.append(front()).append("\n");
                    break;

                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);

    }

    static void push_back(int a) {
        arr[end] = a;
        end++;
    }

    static void push_front(int a) {
        for (int i = end; i >= 1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = a;
        end++;
    }
    static int pop_front() {
        if (end == 0) {
            return -1;
        } else {
            int popNum = arr[0];
            for (int i = 1; i < end; i++) {
                arr[i - 1] = arr[i];
            }
            end--;
            return popNum;
        }
    }
    static int pop_back() {
        if (end == 0) {
            return -1;
        } else {
            return arr[--end];
        }
    }
    static int size() {
        return end;
    }
    static int empty() {
        if (end == 0) {
            return 1;
        } else {
            return 0;
        }
    }
    static int front() {
        if (end == 0) {
            return -1;
        } else {
            return arr[0];
        }
    }
    static int back() {
        if (end == 0) {
            return -1;
        } else {
            return arr[end - 1];
        }
    }
}