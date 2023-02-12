package ProgrammersOneWeek;

import java.util.Arrays;

class NumberWin {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        //A와 B배열이 무작위로 입력되므로, Sorting 과정을 거친다.
        Arrays.sort(A);
        Arrays.sort(B);
        //현재 B팀원이 얻을수 있는 가장 큰 점수를 return하는 것이 목적
        //A 와 B의 길이는 같음(생각해 줄 필요x)
        int bIndex = B.length-1;
        for (int aIndex = A.length - 1; aIndex >= 0; aIndex--) {//A 배열을 기준으로 B가 큰수일 때 1씩 answer를 증가시킨다면
            if (B[bIndex] > A[aIndex]) {
                answer++;
                bIndex--; //bIndex의 경우 A와 비교하면서 한번 사용했으므로 다음에는 사용불가 그다음 큰수로 index변경
            }

        }
        return answer;
    }
}