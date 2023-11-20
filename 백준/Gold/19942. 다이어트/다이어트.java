import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, min, mp, mf, mc, mv;
    static Ingredient[] ingredients, tmp;
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        ingredients = new Ingredient[n + 1];
        tmp = new Ingredient[n + 1];
        min = Integer.MAX_VALUE;
        visited = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        mc = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int protein = Integer.parseInt(st.nextToken());
            int fat = Integer.parseInt(st.nextToken());
            int carbo = Integer.parseInt(st.nextToken());
            int vitamin = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            ingredients[i] = new Ingredient(i, protein, fat, carbo, vitamin, cost);
        }


        for (int i = 1; i <= n; i++) {
            recur(0, 1, i);
        }
//        for (String s : result) {
//            System.out.println(s);
//        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
            Collections.sort(result);
            System.out.println(result.get(0));
        }
    }

    static void recur(int depth, int start, int cnt) {
        if (depth >= cnt) {
            updateResult(cnt);
            return;
        }

        for (int i = start; i <= n; i++) {
            tmp[depth] = ingredients[i];
            recur(depth + 1, i + 1, cnt);
        }
    }

    static void updateResult(int cnt) {
        int tp = 0;
        int tf = 0;
        int tc = 0;
        int tv = 0;
        int tCost = 0;
        for (int i = 0; i < cnt; i++) {
            Ingredient ingredient = tmp[i];
            tp += ingredient.protein;
            tf += ingredient.fat;
            tc += ingredient.carbo;
            tv += ingredient.vitamin;
            tCost += ingredient.cost;
        }
        if (tp >= mp && tf >= mf && tc >= mc && tv >= mv && tCost <= min) {
            if (tCost < min) {
                result.clear();
            }
            sb = new StringBuilder();
            for (int i = 0; i < cnt; i++) {
                sb.append(tmp[i].num).append(" ");
            }
            result.add(sb.toString());
            min = tCost;
        }
    }


    private static class Ingredient {
        int num;
        int protein;
        int fat;
        int carbo;
        int vitamin;
        int cost;

        public Ingredient(int num, int protein, int fat, int carbo, int vitamin, int cost) {
            this.num = num;
            this.protein = protein;
            this.fat = fat;
            this.carbo = carbo;
            this.vitamin = vitamin;
            this.cost = cost;
        }


    }
}