package lv1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
        List<Integer> numList = new ArrayList<>();
        numList.add(3);
        numList.add(4);
        System.out.println("num "+numList.size());
        numList.clear();
        System.out.println(numList.size());


        Integer remove = pq.remove();
        System.out.println(pq.peek());
        System.out.println(remove);
    }
}
