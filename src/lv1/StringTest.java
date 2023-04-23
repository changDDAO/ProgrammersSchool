package lv1;

public class StringTest {
    public static void main(String[] args) {
        String s = "changhz";

        if(s.contains("c")) System.out.println("yes");

        char[] temp = s.toCharArray();
        Character a = 'a';
        System.out.println(Character.valueOf(a.charValue()));
        System.out.println((temp[temp.length-1]-'a'));







    }
}
