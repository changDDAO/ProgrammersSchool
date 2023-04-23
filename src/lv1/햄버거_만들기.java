package lv1;

import java.util.Stack;

public class 햄버거_만들기 {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int ingre : ingredient){
            stack.push(ingre);
            int size = stack.size();
            if(size>=4&&stack.get(size-1)==1&&stack.get(size-2)==3
                    &&stack.get(size-3)==2&&stack.get(size-4)==1){
                for(int i=0;i<4;i++){
                    stack.pop();
                }
                answer++;
            }
        }
        return answer;
    }
}
