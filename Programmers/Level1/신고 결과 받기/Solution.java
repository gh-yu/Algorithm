import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Map<String, HashSet<String>> reportMap = new HashMap<>(); // 신고 목록
        
        // 신고 목록 초기화
        for (String id : id_list) {
            reportMap.put(id, new HashSet<String>());
        }
        
        // 신고된 유저별 신고한 아이디 추가
        for (String r : report) {
            String reporter = r.split(" ")[0];
            String reportedUser = r.split(" ")[1];
            reportMap.get(reportedUser).add(reporter);
        }
        
        int[] result = new int[id_list.length];
        
        // 메일 보낸 횟수 계산
        for (String id : id_list) {
            if (reportMap.get(id).size() >= k) {
                for (String reporter : reportMap.get(id)) {
                    int idx = Arrays.asList(id_list).indexOf(reporter);
                    result[idx]++;
                }
            }
        }
        
        return result;
    }  
}