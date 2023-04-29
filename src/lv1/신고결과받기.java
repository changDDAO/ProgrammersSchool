package lv1;

import java.util.*;

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int [] result = new int[id_list.length];
        Map<String, HashSet<String>> reportedByMap = new HashMap<>();
        Map<String, Integer> idxMap = new HashMap<>();
        for(int i = 0; i<id_list.length; i++){
            String id = id_list[i];
            reportedByMap.put(id,new HashSet<>());
            idxMap.put(id,i);
        }
        for(String fromTo: report){
            String [] temp = fromTo.split(" ");
            String from = temp[0];
            String to = temp[1];
            reportedByMap.get(to).add(from);
        }

        for(int i=0;i<id_list.length;i++){
            HashSet<String> fromSet = reportedByMap.get(id_list[i]);
            if(fromSet.size()>=k){
                for(String name: fromSet){
                    result[idxMap.get(name)]++;
                }
            }
        }
        return result;
    }
    //원래 생각했던 풀이
    /*public int[] solution(String[] id_list, String[] report, int k) {
        // key: 신고당한놈, value: 몇명한테 당했는지
        Map<String, Set<String>> map = new HashMap<>();

        for (String rep : report) {
            String[] arr = rep.split(" ");
            Set<String> set = map.getOrDefault(arr[1], new HashSet<>());
            set.add(arr[0]);
            map.put(arr[1], set);
        }

        // key: 알림받을 놈, value: 몇번 알림받을지
        Map<String, Integer> countMap = new LinkedHashMap<>();

        for (String id : id_list) {
            countMap.put(id, 0);
        }

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            if (entry.getValue().size() >= k) { // 정지당할놈
                for (String value : entry.getValue()) {
                    countMap.put(value, countMap.getOrDefault(value, 0) + 1);
                }
            }
        }

        return countMap.values().stream().mapToInt(Integer::intValue).toArray();
    }*/
}
