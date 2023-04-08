package ProgrammersOneWeek;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int i =0;
        int j = 0;
        for(; i<A.length;){
            while (j < B.length && A[i] > B[j]){
                j++;
            }
            if (j == B.length)
                break;

            answer++;
            i++;
            j++;
        }

        return answer;
    }


}
