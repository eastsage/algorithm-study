import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> prog = new ArrayDeque<>();
        Queue<Integer> spd  = new ArrayDeque<>();
        for (int p : progresses) prog.offer(p);
        for (int s : speeds)    spd.offer(s);

        List<Integer> res = new ArrayList<>();

        while (!prog.isEmpty()) {
            // 하루 경과: 현재 남은 개수만큼 진행도 += 속도
            int size = prog.size();
            for (int i = 0; i < size; i++) {
                int p = prog.poll();
                int s = spd.poll();
                prog.offer(p + s);
                spd.offer(s);
            }

            // 배포: 앞에서부터 100 이상인 만큼 둘 다 poll
            int deployed = 0;
            while (!prog.isEmpty() && prog.peek() >= 100) {
                prog.poll();
                spd.poll();
                deployed++;
            }
            if (deployed > 0) res.add(deployed);
        }

        return res;
    }
}
