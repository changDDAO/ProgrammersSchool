package ProgrammersFourWeek;

import java.util.*;

public class TopologySort {
    class ListMap {
        private Map<String, List<String>> map = new HashMap<>();

        List<String> get(String key) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());//key가없다면 key 생성후 리스트 초기화해주기
            }
            return map.get(key);
        }
        void append(String key, String value) {
            get(key).add(value);
        }
    }

    class CountMap {
        private Map<String, Integer> map = new HashMap<>();

        Integer get(String key) {
            if (!map.containsKey(key)) {
                map.put(key,0);
            }
            return map.get(key);
        }
        void add(String key, Integer value) {
            map.put(key, get(key) + value);
        }
    }


        public String[] solution(String[] s1, String[] s2, String k) {
            ListMap graph = new ListMap();
            for (int i = 0; i < s1.length; i++) {
                graph.get(s2[i]).add(s1[i]);//새로정의한 ListMap을 이용 만약 s2 인덱스값이 없다면 key로 만들어놓고 거기다가 값대입
                //강의 에다가 선수강의 대입
            }
            Queue<String> queue = new PriorityQueue<>(); //우선순위큐므로 알파벳 오름차순(default)
            ListMap graphK = new ListMap();//K로 연결되는 강의로만 구성하는 그래프
            CountMap inDegree = new CountMap();

            //LIFO방식으로 graphK생성하기
            Stack<String> stack = new Stack<>();
            Set<String> visited = new HashSet<>();
            stack.push(k);
            visited.add(k);

            while (!stack.isEmpty()) {
                String node = stack.pop();

                if (graph.get(node).isEmpty()) {
                    queue.offer(node);
                    continue;
                }
                for (String prevSubject : graph.get(node)) {
                    inDegree.add(node,1);
                    graphK.append(prevSubject,node);
                    if(visited.contains(prevSubject))continue;
                    stack.push(prevSubject);
                    visited.add(prevSubject);
                }
            }
            List<String> answer = new ArrayList<>();
            while (!queue.isEmpty()) {
                String node = queue.poll();
                answer.add(node);
                for (String next : graphK.get(node)) {
                    inDegree.add(next, -1);
                    if (inDegree.get(next) == 0) {
                        // 감소된 진입차수가 0이면 큐에 삽입
                        queue.offer(next);
                    }
                }
            }

            return answer.toArray(String[]::new);


        }




}
