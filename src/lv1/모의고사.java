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
 //다른사람풀이
    /*public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == a[i%a.length]) {score[0]++;}
            if(answers[i] == b[i%b.length]) {score[1]++;}
            if(answers[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }*/
