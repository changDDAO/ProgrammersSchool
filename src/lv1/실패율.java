package lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<User> userList = new ArrayList<>();
        int length = stages.length;
        for(int i = 1; i<=N;i++){
            int cnt =0;
            for(int stage : stages){
                if(stage==i)cnt++;
            }
            double fRate = 0;
            if(length>=1) fRate  = (double)cnt/length;
            length-=cnt;
            userList.add(new User(i,fRate));
        }
        Collections.sort(userList);
        for(int i=0;i<userList.size();i++){
            answer[i] = userList.get(i).stage;
        }

        return answer;
    }
    public class User implements Comparable<User>{
        int stage;
        double failRate;

        public User(int stage, double failRate){
            this.stage = stage;
            this.failRate = failRate;
        }

        @Override
        public int compareTo(User o){
            if(this.failRate==o.failRate)
                return this.stage - o.stage;

            return Double.compare(o.failRate,this.failRate);
        }

    }
}
