package ProgrammersFourWeek;

import java.util.*;

public class TopologyCodeUp {
    class ListMap{
        Map<String, List<String>> map = new HashMap<>();// 선수과목을 담을 key에 대한 List 초기화방식
        List<String> get(String key) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            return map.get(key);
        }

        void append(String key, String value) {
            get(key).add(value);
        }
      //원래 primitive type 으로 생성하여 초기화 하였지만 공간적으로 필요한 부분만 생성하여 쓰도록 HashMap 사용 <--CodeUp
    }
    class CountMap{
        Map<String, Integer> map = new HashMap<>();
        Integer get(String key) {
            if (!map.containsKey(key)) {
                map.put(key,0);
            }
            return map.get(key);
        }
        void add(String key, Integer value) {
            map.put(key, get(key)+value);
        }

    }
    public String []solution(String[]s1, String[]s2, String k) {
       ListMap graph = new ListMap();
        for (int i = 0; i < s1.length; i++) {
            graph.get(s2[i]).add(s1[i]);
        }//graph 초기화 해주기 (특정과목에 선수과목 대입)
        //과목이 알파벳 순으로 우선순위를 가지므로
        Queue<String> queue = new PriorityQueue<>();
        CountMap inDegree = new CountMap();
        ListMap graphK = new ListMap();//K로 연결되는 강의로만 구성하는 그래프
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();

        stack.push(k);
        visited.add(k);
        while (!stack.isEmpty()) {
            String node = stack.pop();
            if (graph.get(node).isEmpty()) {//graph에 담긴 선수과목이 없다면
                queue.offer(node);
                continue;
            }
            for (String prev : graph.get(node)) {
                inDegree.add(node,1); //현재 노드에 담겨있는 수만큼 1씩증가
                graphK.append(prev,node);
                if(visited.contains(prev)) continue;
                stack.push(prev);
                visited.add(prev);
            }
        }
        List<String> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            String node = queue.poll();
            answer.add(node);
            for (String next : graphK.get(node)) {
                inDegree.add(next,-1);//현재 수강과목이후에 과목들의 진입차수를 1씩 감소 시키기
                if(inDegree.get(next)==0)
                    queue.offer(next);
            }
        }


    return answer.toArray(String[]::new);


    }
}
