package lv1;

public class 키패드_누르기 {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb =new StringBuilder();
        //left, mid, right 분간방법은 현재 숫자를 %3 했을때 나머지가 1이면 left
        //2면 mid, 0이면 right임
        //그리고 매번 숫자를 누를때마다 왼쪽엄지나 오른쪽엄지의 위치가 바뀌니까 그위치를 기억하고 있
        //는 변수가 필요함
        //mid같은 경우에는 왼손엄지나 오른손 엄지중 위치가 가까운 쪽 거리가 같다면? hand변수에 담긴 손으로 누름 정리 끝 드가자!
        int left = 10, right =12;
        for(int num: numbers){
            if(num==0)num=11;
            int pos = num%3;
            switch(pos){
                case 0 -> {
                    sb.append("R");
                    right = num;
                }
                case 1 -> {
                    sb.append("L");
                    left = num;
                }
                case 2 ->{
                    int fromL = Math.abs(left-num)/3+Math.abs(left-num)%3;
                    int fromR = Math.abs(right-num)/3+Math.abs(right-num)%3;
                    if(fromL<fromR){
                        sb.append("L");
                        left = num;
                    }else if(fromL>fromR){
                        sb.append("R");
                        right = num;
                    }else{// 즉 거리가 같을 때
                        String temp = hand.equals("right")?"R":"L";
                        sb.append(temp);
                        if(temp.equals("L"))left = num;
                        else right = num;
                    }

                }
            }
        }
        return sb.toString();
    }
}
