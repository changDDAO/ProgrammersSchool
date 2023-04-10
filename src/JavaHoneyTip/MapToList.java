package JavaHoneyTip;

import java.util.*;

public class MapToList {
    public static void main(String[] args) {
        // HashMap 생성
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("A", 3);
        hashMap.put("B", 1);
        hashMap.put("C", 2);

        // HashMap의 값을 List로 변환
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(hashMap.entrySet());

// 값(Value)으로 오름차순 정렬
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return (o1.getValue()).compareTo(o2.getValue());
//            }
//        });
        //값을 내림차순으로 정렬
        Collections.sort(list,(Map.Entry<String,Integer> map1,Map.Entry<String,Integer> map2)->map2.getValue()- map1.getValue());

// 정렬된 결과 출력
        for (
                Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

}
