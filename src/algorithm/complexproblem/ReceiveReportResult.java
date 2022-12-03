package algorithm.complexproblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ReceiveReportResult {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, HashSet<String>> userBlackLists = new HashMap<>();
        Map<String, Integer> reportedList = new HashMap<>();


        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> blackUsers = new HashSet<>();
            userBlackLists.put(id_list[i], blackUsers);
            reportedList.put(id_list[i], 0);
        }

        for (String s : report) {
            String[] temp = s.split(" ");
            String reportingID = temp[0];
            String reportedID = temp[1];
            userBlackLists.get(reportedID).add(reportingID);
        }

        for (String reportedUser : userBlackLists.keySet()) {
            HashSet<String> userForSend = userBlackLists.get(reportedUser);
            if (userForSend.size() >= k) {
                for (String userId : userForSend) {
                    reportedList.put(userId, reportedList.get(userId) + 1);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = reportedList.get(id_list[i]);
        }
        return answer;
    }
}
