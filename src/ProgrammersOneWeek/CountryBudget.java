package ProgrammersOneWeek;

import java.util.Arrays;

class CountryBudget {
    public int solution(int[] budgets, int M) {
        //budgets 배열의 경우 각 지방이 요청하는 예산을 담고있음, 전체 국가 총예산 ==M
        // goal : 가능한한 최대의 상한가를 return
        int answer = 0;
        int min =1; //제한사항에 최소 예산이 1부터
        int max = Arrays.stream(budgets).max().getAsInt();
        while (min <= max) {
            int mid = (min+max)/2;//현재 상한가
            int sum = 0;
            for (int budget : budgets) {
                if(budget>=mid) sum+= mid;
                else sum+=budget;
            }

//           int sum = IntStream.of(budgets).map(b->Math.min(b,mid)).sum();// budget 배열을 순회하면서 현재 상한가보다 이하이면
            // 그 지방에서 요청하는 예산으로 mapping or else 상한가 로 mapping // 이거 효율성에서 감점받아서 그냥 향상된 for문으로 대체
            if (sum <= M) {//현재 각 지방에서 요청한 예산합이 국가예산보다 작거나 같다면
                min = mid + 1;//상한가 올려주기
                answer = mid;
            } else max = mid-1; //현재 각지방의 예산합이 국가예산보다 크다면 현재 상한가를 낮춘다

        }

        return answer;
    }
}

