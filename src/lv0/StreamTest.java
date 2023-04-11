package lv0;

import java.util.stream.IntStream;

public class StreamTest {
    public static void main(String[] args) {
        IntStream.range(0,10).forEach(v-> System.out.println(v));
        //0~9
    }
}
