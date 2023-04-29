package lv1;

public class 둘만의암호 {
    //나의 풀이
    public String solution(String s, String skip, int index) {
        char [] cArray = s.toCharArray();
        for(int i=0; i<cArray.length;i++){
            for(int j =0;j<index;j++){
                cArray[i]++;
                if(cArray[i]>'z') cArray[i]-=26;
                while(skip.contains(String.valueOf(cArray[i]))){
                    cArray[i]++;
                    if(cArray[i]>'z')
                        cArray[i]-=26;
                }

            }

        }
        String answer = String.valueOf(cArray);
        return answer;
    }


    //다른사람의 좋은 풀이
    /*    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char letter : s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (!skip.contains(String.valueOf(temp))) {
                    idx += 1;
                }
            }
            answer.append(temp);
        }

        return answer.toString();
    }*/
}
