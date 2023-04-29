package lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class 달리기경주 {
    public Map<String, Integer> pInfo = new HashMap<>();
    public String[] solution(String[] players, String[] callings) {
        makeInfo(players);
        Arrays.stream(callings).forEach(
                player->{
                    int idx = pInfo.get(player);
                    String prevPlayer = players[idx-1];
                    players[idx-1] = players[idx];
                    players[idx] = prevPlayer;
                    pInfo.put(player,idx-1);
                    pInfo.put(prevPlayer,idx);
                }
        );
        return players;


    }
    public void makeInfo(String [] players){
        IntStream.range(0,players.length)
                .forEach(index -> pInfo.put(players[index],index));
    }
        //2번째풀이
    /*public String[] solution(String[] players, String[] callings) {
        int n = players.length;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n;i++){
            map.put(players[i],i);
        }//원래 players 배열에 담겨있는 선수들의 인덱스를 저장해둠

        for(String calling : callings){
            int idx = map.get(calling);
            String temp = players[idx-1];
            players[idx-1] = players[idx];
            players[idx] = temp;
            map.put(players[idx-1],idx-1);
            map.put(players[idx],idx);
        }

        return players;
    }*/
}
