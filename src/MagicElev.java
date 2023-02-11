public class MagicElev {
    public int solution(int storey) {
        //현재 문제에서 기준이 되는 값은 절댓값 10의 배수이다.
        //일의 자리 숫자 경우 더하거나 빼서 10(또는 0)이 되면 된다.
        //일의 자리숫자 부터 확인하면서 bottomUp 방식의 느낌으로 십의 자리 백의자리 등등 갯수확인(recur이 좋아보임)
        //궁극적인 목적은 마법의돌을 가장 적게 사용

        return magicStone(storey);

    }
    public int magicStone(int elv){
        //종료조건 명시
        if(elv<=1) return elv; // maybe 0 or 1
        int down10 = elv%10; //일의 자릿수
        int up10 = elv/10;// 10의 배수

        int caseA = down10 + magicStone(up10);
        int caseB = (10-down10) + magicStone(up10+1);
        return Math.min(caseA,caseB);
    }
}