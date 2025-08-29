import java.util.*;

class Solution {
    static List<Integer>[] edges;
    static int n, m;
    static String[] ws;     // words 저장
    static String beginS;   // begin 저장
    static int beginIdx;    // 그래프에서 begin 노드 인덱스 (마지막)
    static int targetIdx;   // words에서 target의 인덱스

    public int solution(String begin, String target, String[] words) {
        // target이 words에 없으면 변환 불가
        int tIdx = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                tIdx = i;
                break;
            }
        }
        if (tIdx == -1) return 0;

        ws = words;
        beginS = begin;
        n = words.length + 1;      // words + begin
        m = begin.length();
        beginIdx = n - 1;          // begin을 마지막 인덱스로
        targetIdx = tIdx;

        // 인접 리스트 초기화
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();

        // 모든 쌍에 대해 간선 연결 (한 글자만 다르면 연결)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String a = getWord(i);
                String b = getWord(j);
                if (isAdjacent(a, b)) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        // BFS로 begin -> target 최단 거리
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        dist[beginIdx] = 0;
        q.add(beginIdx);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == targetIdx) return dist[cur];
            for (int nxt : edges[cur]) {
                if (dist[nxt] == -1) {
                    dist[nxt] = dist[cur] + 1;
                    q.add(nxt);
                }
            }
        }
        return 0; // 도달 불가
    }

    // 인덱스에 해당하는 단어 반환: 0..n-2 => words, n-1 => begin
    static String getWord(int idx) {
        return (idx == n - 1) ? beginS : ws[idx];
    }

    // 두 단어가 정확히 한 글자만 다른지
    static boolean isAdjacent(String a, String b) {
        if (a.length() != b.length()) return false;
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }
}
