import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Customer {
    String name;
    int arrivedTime;

    public Customer(String name, String arrivedTime) {
        this.name = name;
        this.arrivedTime = stiTime(arrivedTime);
    }

    public String getName() {
        return name;
    }

    public int getArrivedTime() {
        return arrivedTime;
    }

    public int stiTime(String time) {
        String[] pTime = time.split(":");
        int fixedTime = Integer.parseInt(pTime[0]) * 60 + Integer.parseInt(pTime[1]);
        return fixedTime;
    }
}

class Solution {

    public String[] solution(String[][] booked, String[][] unbooked) {
        Queue<Customer> bookedCustomer = new LinkedList<>();
        Queue<Customer> unbookedCustomer = new LinkedList<>();
        for (String[] bc : booked) {
            bookedCustomer.add(new Customer(bc[1], bc[0]));
        }
        for (String[] ubc : unbooked) {
            unbookedCustomer.add(new Customer(ubc[1], ubc[0]));
        }
        List<String> cName = new ArrayList<>();
        int curTime = Math.min(bookedCustomer.peek().getArrivedTime(), unbookedCustomer.peek().getArrivedTime());
        while (!bookedCustomer.isEmpty() || !unbookedCustomer.isEmpty()) {
            if (bookedCustomer.isEmpty()){
                for(Customer c: unbookedCustomer)cName.add(c.getName());
                break;
            }

            if (unbookedCustomer.isEmpty()) {
                for (Customer c : bookedCustomer) cName.add(c.getName());
                break;
            }
            Customer c;
            if (curTime >= bookedCustomer.peek().getArrivedTime()) {
                cName.add(bookedCustomer.poll().getName());
                curTime += 10;
            } else if (curTime >= unbookedCustomer.peek().getArrivedTime()) {
                cName.add(unbookedCustomer.poll().getName());
                curTime += 10;
            } else {
                if (bookedCustomer.peek().getArrivedTime() < unbookedCustomer.peek().getArrivedTime()) {
                    c = bookedCustomer.poll();
                    cName.add(c.getName());
                    curTime = c.getArrivedTime() + 10;
                } else {
                     c= unbookedCustomer.poll();
                    cName.add(c.getName());
                    curTime = c.getArrivedTime() + 10;
                }
            }

        }
        return cName.toArray(String[]::new);
    }
}