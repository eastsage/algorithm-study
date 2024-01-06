

import java.util.*;
import java.io.*;

public class Main {
    static class Factor {
        long p, c;

        public Factor(long p, long c) {
            this.p = p;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        final int LIMIT = 1000001;
        boolean[] chk = new boolean[LIMIT];
        ArrayList<Long> primes = new ArrayList<>();

        for (int i = 2; i < LIMIT; i++) {
            if (!chk[i]) {
                primes.add((long) i);
                for (long j = (long)i * i; j < LIMIT; j += i) {
                    chk[(int)j] = true;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            ArrayList<Factor> factors = new ArrayList<>();

            for (int i = 0; k != 1 && i < primes.size(); i++) {
                long cnt = 0;
                while (k % primes.get(i) == 0) {
                    k /= primes.get(i);
                    cnt++;
                }
                if (cnt > 0) {
                    factors.add(new Factor(primes.get(i), cnt));
                }
            }

            if (k != 1) {
                factors.add(new Factor(k, 1));
            }

            long ans = Long.MAX_VALUE;

            for (Factor f : factors) {
                long cnt = 0;
                long curp = f.p;
                long lgLimit = (long) (Math.log(n) / Math.log(f.p));

                for (int i = 0; i < lgLimit; i++) {
                    cnt += n / curp;
                    curp *= f.p;
                }

                ans = Math.min(ans, cnt / f.c);
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}

