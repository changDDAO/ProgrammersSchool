package lv1;

public class StringTest {
    public static void main(String[] args) {
        String s = "changho";
//        if(s.contains("chang"))
//            s=s.replace("chang","1");
        StringBuilder sb = new StringBuilder(s);
        String temp = sb.substring(4).toString();
        String a = "281222";
        String b = "291";
        int res = a.compareTo(b);
        System.out.println(res);
        System.out.println(a.indexOf('2',2));



    }
}
