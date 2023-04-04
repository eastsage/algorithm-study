// KMP 알고리즘(Knuth–Morris–Pratt Algorithm)
// O(N+M)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] text = br.readLine().toCharArray();
        char[] pattern = br.readLine().toCharArray();

        int tLength = text.length;
        int pLength = pattern.length;

        //부분 일치 테이블 생성
        int[] pi = new int[pLength];
        for (int i = 1, j = 0; i < pLength; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = pi[j - 1];
            }
            if (pattern[i] == pattern[j]) {
                pi[i] = ++j;
            } else {
                pi[i] = 0;
            }
        }

        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        // i : 텍스트 포인터 , j: 패턴 포인터
        // i : prefix pointer, j : suffix pointer
        for (int i = 0, j = 0; i < tLength; ++i) {//본문은 모두 확인함. 패턴포인터만 움직임

            while (j > 0 && text[i] != pattern[j]) {
                j = pi[j - 1];
            }
            if (text[i] == pattern[j]) { //두 글자 일치
                if (j == pLength - 1) { // j가 패턴의 마지막 인덱스라면
                    cnt++; // 카운트 증가
                    list.add(i - j);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        System.out.println(cnt);
        for (Integer idx : list) {
            System.out.print((idx + 1) + " ");
        }
//        if (cnt > 0) {
//            System.out.println(list.get(0) + 1);
//        }
    }
}