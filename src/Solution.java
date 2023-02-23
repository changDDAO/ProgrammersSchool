import java.util.Arrays;

class Solution {
    public int solution(int[] people, int[] tshirts) {
        int answer = 0;
        Arrays.sort(people);
        Arrays.sort(tshirts);
        int tIndex = tshirts.length-1;
        for (int i = people.length - 1; i >= 0&&tIndex>=0; i--) {
            if (tshirts[tIndex] >= people[i]) {
                answer++;
                tIndex--;
            }
        }
        return answer;
    }
}