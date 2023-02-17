//문제를 풀기전에 생각을 정리해보자.
//1. 예약자든 예약자가 아니든 방문시간이 빠른 순으로 처리한다.
//2. fifo first in first out 방식의 자료구조 즉 queue를 사용한다.
//9시 10분 예약자 1__ 9시 비예약자 2__ 9시 5분 비예약자 3
//(조건이 있음 만약 현재시간이 9시 10분일때 9시에 비예약자가 방문했고 10분동안 도중에 멈춤없이 상담진행
//그렇다면 현재시간은 9시 10분 비예약자가 9시 5분에 도착하였지만 9시10분에 예약한 사람이 있으므로 그사람부터 처리 그후 비예약자 2 처리
//결론적으로 3 1 2의 순서로 이름이 담긴 String [] return

import java.util.*;

class Visitor{
    private String name;
    private int arrivedTime;

    public Visitor(String name, String arrivedTime) {
        this.name = name;
        this.arrivedTime = stiTime(arrivedTime);
    }

    public String getName() {
        return name;
    }

    public int getArrivedTime() {
        return arrivedTime;
    }

    private int stiTime(String time) {
        int [] temp = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        int intTime = temp[0]*60+temp[1];
        return intTime;
    }

}
class ReservationDDAO {
    public String[] solution(String[][] booked, String[][] unbooked) {
        //예약자든 아니
        List<String> vName = new ArrayList<>();
        Visitor visitor;
        Queue<Visitor> bookedVisitor = new LinkedList<>();
        Queue<Visitor> unbookedVisitor = new LinkedList<>();
        for (String[] bV : booked) {
            bookedVisitor.add(new Visitor(bV[1],bV[0]));
        }
        for (String[] uV : unbooked) {
            unbookedVisitor.add(new Visitor(uV[1],uV[0]));
        }
        int curTime = Math.min(bookedVisitor.peek().getArrivedTime(),unbookedVisitor.peek().getArrivedTime()); //현재시간
        while (!bookedVisitor.isEmpty() || !unbookedVisitor.isEmpty()) {
            if (bookedVisitor.isEmpty()) {//예약방문자들 큐가 비었다면 남아있는 비예약자들을 리스트에 추가(정렬돼있으므로 다른 고려사항이없음)
                for(Visitor visitor1: unbookedVisitor)
                vName.add(visitor1.getName());
                break;
            }
            if (unbookedVisitor.isEmpty()) {//비예약방문자들 큐가 비었다면 남아있는 예약자들을 리스트에 추가(정렬돼있으므로 다른 고려사항이없음)
                for(Visitor visitor1: bookedVisitor)
                vName.add(visitor1.getName());
                break;
            }

            if (curTime >= bookedVisitor.peek().getArrivedTime()) { //현재시간이 예약방문자 도착시간 이상이라면 바로 상담진행
                vName.add(bookedVisitor.poll().getName());
                curTime+=10;
            } else if (curTime >= unbookedVisitor.peek().getArrivedTime()) {
                vName.add(unbookedVisitor.poll().getName());
                curTime += 10;
            } else {
                if (bookedVisitor.peek().getArrivedTime() < unbookedVisitor.peek().getArrivedTime()) {
                    visitor = bookedVisitor.poll();
                    vName.add(visitor.getName());
                } else {
                    visitor = unbookedVisitor.poll();
                    vName.add(visitor.getName());
                }
                curTime = visitor.getArrivedTime()+10;
            }

        }
        return vName.toArray(String[]::new);
    }
}