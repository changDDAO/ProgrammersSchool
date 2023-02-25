package ProgrammersThreeWeek;

import java.util.ArrayList;
import java.util.List;

public class Disjoint {
    public int [] parent = new int[100001];
    List<List<Integer>> graph = new ArrayList<>();

    public int findParent(int x) {
        if(parent[x]==x) return x;
        return parent[x] = findParent(parent[x]);
    }

    public void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b]=a;
        else parent[a]=b;
    }

    public int solution(int[][] reply) {
        int answer = 0;
        int people = -1 ;
        for(int [] c:reply)people++;
        for (int i = 1; i <= people; i++) {
            parent[i]=i; //자기 자신으로 초기화
            graph.add(new ArrayList<>());
        }
        for (int[] wantPerson : reply) {

        }




        return answer;
    }
}
