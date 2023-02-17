package 프로그래머스.Lv1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 신고_결과_받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};

        //신고 아이디와 신고한 사람들의 hashSet을 담는다
        Map<String, HashSet<String>> reportedMap = new HashMap<>();
        //신고된 id, 메일 수
        Map<String, Integer> answerMap = new HashMap<>();

        //초기화
        for(int i=0; i<id_list.length; i++) {
            HashSet<String> reportingId = new HashSet<>(); //신고한 ID
            reportedMap.put(id_list[i], reportingId);

            answerMap.put(id_list[i], 0);
        }

        for(String s : report) {
            String[] reportStr = s.split(" ");
            String reportingID = reportStr[0]; //신고한 ID
            String reportedId = reportStr[1]; //신고당한 ID

            reportedMap.get(reportedId).add(reportingID);
        }

        for(String reportedUser : reportedMap.keySet()) {
            HashSet<String> userForSend = reportedMap.get(reportedUser);

            if(userForSend.size() >= k) {
                for(String userId : userForSend) {
                    answerMap.put(userId, answerMap.get(userId) + 1);
                }
            }
        }

        for(int i=0; i<id_list.length; i++) {
            answer[i] = answerMap.get(id_list[i]);
        }

        return answer;
    }
}
