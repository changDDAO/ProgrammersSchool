package ProgrammersTwoWeek;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class T_shirtsProblem {

    public int solution(int[] people, int[] tshirts) {
        int answer = 0;
        List<Integer> peopleList = Arrays.stream(people).boxed().collect(Collectors.toList());
        List<Integer> tshirtList = Arrays.stream(tshirts).boxed().collect(Collectors.toList());
       peopleList.sort((a,b)->b-a);
       tshirtList.sort((a,b)->b-a);
        int index = 0;
        for (int i = 0; i < peopleList.size() && index < tshirtList.size(); i++) {
            if (tshirtList.get(index) >= peopleList.get(i)) {
                answer++;
                index++;
            }
        }
        return answer;
    }
}

