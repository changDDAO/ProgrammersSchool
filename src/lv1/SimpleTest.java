package lv1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SimpleTest {
    public static void main(String[] args) {
        String s = Integer.toBinaryString(9);
        System.out.println(s);

        PriorityQueue<Integer> pq = new PriorityQueue<>(3, Comparator.reverseOrder());
        pq.offer(7);
        pq.offer(2);
        pq.offer(5);
        pq.offer(1);


        Integer remove = pq.remove();
        System.out.println(pq.peek());
        System.out.println(remove);
    }
}
