import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int n, m, k, s, e;
    static int[] pSum, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                list.add(i);
            }
        }

        s = 0;
        e = k - 1;
        int res = 1000001;
        while (e < list.size()) {
            res = Math.min(res, list.get(e) - list.get(s) + 1);
            s++;
            e++;
        }
        if (res == 1000001) res = -1;
        System.out.println(res);
    }
}