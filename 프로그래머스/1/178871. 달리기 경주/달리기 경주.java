import java.util.*;

class Solution {
    static HashMap<String, Integer> splayers = new HashMap<>();
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        for (int i = 0; i < players.length; i++) {
            splayers.put(players[i], i);
        }
        
        for (String caller : callings) {
            int callerRank = splayers.get(caller);
            String prevName = players[callerRank - 1];
            
            players[callerRank - 1] = caller;
            players[callerRank] = prevName;
        
            splayers.put(caller, callerRank - 1);
            splayers.put(prevName, callerRank);
        }
        return players;
    }

}