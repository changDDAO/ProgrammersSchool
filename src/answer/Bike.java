package answer;
class Bike {

    public int solution(int[][] cost, int[][] order) {
        int answer = 0;

        int maxMonth = 0; //최대 개월수
        for (int[] oneOrder : order) maxMonth = Math.max(maxMonth, oneOrder[0]);

        int[] orderAtMonth = new int[maxMonth];
        int need = 0;
        int made = 0;
        for (int[] o : order) {
            // order 배열이 정렬되어 있지 않음에 주의하세요.
            orderAtMonth[o[0] - 1] += o[1]; // 월을 index로 사용하기 위해 -1을 해줍니다
            need += o[1];
        }

        for (int i = 0; i < cost.length - 1; i++) {
            if (need == 0 || made >= need) break;

            int price = cost[i][1];
            int limit = cost[i + 1][0] - cost[i][0];
            int rest = 0;

            for (int j = 0; j < maxMonth; j++) {
                if (need == 0 || made >= need) break;

                int making = Math.min(limit, need - made);

                answer += making * price;
                made += making;
                need -= orderAtMonth[j];

                if (orderAtMonth[j] == 0) continue; // 납품을 안해도 됩니다.

                int delivery = Math.min(made, orderAtMonth[j]);

                // 납품할때가 되면 만들어놓은 것에서 빼줍니다.
                made -= delivery;
                orderAtMonth[j] -= delivery;
                rest += orderAtMonth[j]; // 납품하고도 남은것은 다음구간에서 만들어야 합니다.
            }

            need = rest;
            made = 0;
        }

        // 나머지 것들은 최종구간의 가격을 적용합니다.
        answer += need * cost[cost.length - 1][1];
        return answer;
    }
}