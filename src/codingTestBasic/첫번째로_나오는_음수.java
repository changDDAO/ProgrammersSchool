package codingTestBasic;

public class 첫번째로_나오는_음수 {
    public int solution(int[] num_list) {
        for(int i= 0; i<num_list.length; i++){
            if(num_list[i]<0)
                return i;
        }
        return -1;
    }
}
