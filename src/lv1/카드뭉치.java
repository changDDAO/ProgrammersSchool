package lv1;

public class 카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int idx1 = 0;
        int idx2 = 0;
        boolean check = true;
        for(int i =0; i<goal.length;i++){
            if(idx1<cards1.length&&cards1[idx1].equals(goal[i])){
                idx1++;
            }else if(idx2<cards2.length&&cards2[idx2].equals(goal[i])){
                idx2++;
            }else{
                check = false;
                break;
            }
        }
        if(check) return "Yes";
        else return "No";



    }
}
