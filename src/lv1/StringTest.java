package lv1;

public class StringTest {
    public static void main(String[] args) {
        String s = "changhz";

        if(s.contains("c")) System.out.println("yes");

/*        char[] temp = s.toCharArray();
        Character a = 'a';
        System.out.println(Character.valueOf(a.charValue()));
        System.out.println((temp[temp.length-1]-'a'));*/
        System.out.println(s.indexOf('k'));
        String a = "A.b.C";
        String [] b =a.split("\\.");
        for (String s1 : b) {
            System.out.println("s1 = " + s1);

        }


    }
}
