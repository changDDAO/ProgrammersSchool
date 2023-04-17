package lv1;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    class Supoza{
        int idx;
        int score;
        public Supoza(int idx, int score){
            this.idx = idx;
            this.score = score;
        }
    }

    public int[] solution(int[] answers) {
        int []answer ={};
        int[]supo1 ={1,2,3,4,5};
        int[]supo2 ={2,1,2,3,2,4,2,5};
        int[]supo3 = {3,3,1,1,2,2,4,4,5,5};
        List<Supoza> supozaList = new ArrayList<>();
        List<Integer> retList = new ArrayList<>();
        supozaList.add(new Supoza(1,getScore(answers,supo1)));
        supozaList.add(new Supoza(2,getScore(answers,supo2)));
        supozaList.add(new Supoza(3,getScore(answers,supo3)));
        supozaList.sort((a,b)->a.score-b.score);
        int maxScore = supozaList.get(supozaList.size()-1).score;
        retList.add(supozaList.get(supozaList.size()-1).idx);
        for(int i=supozaList.size()-2;i>=0;i--){
            if(supozaList.get(i).score!=maxScore)
                break;
            else
                retList.add(supozaList.get(i).idx);
        }
        return retList.stream().sorted((a,b)->a-b).mapToInt(x->x).toArray();


    }
    public int getScore(int []answer, int []supo){
        int count = 0;
        int supoLen = supo.length;
        int supoIdx = 0;
        for(int i=0;i<answer.length;i++){
            if(supoIdx==supoLen)supoIdx = 0;
            if(answer[i]==supo[supoIdx])
                count++;
            supoIdx++;
        }
        return count;
    }
}
