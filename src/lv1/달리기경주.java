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
}
