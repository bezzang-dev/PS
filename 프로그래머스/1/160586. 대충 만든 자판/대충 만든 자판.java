import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) {
            String curKeyMap = keymap[i];

            for (int j = 0; j < curKeyMap.length(); j++) {
                char curChar = curKeyMap.charAt(j);
                if (map.containsKey(curChar)) {
                    map.put(curChar, Math.min(map.get(curChar), j + 1)); // j가 0부터 시작하므로 +1을 해줘야 최소 횟수가 됨
                } else {
                    map.put(curChar, j + 1);
                }
            }
        }

        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String curTarget = targets[i];
            for (char c : curTarget.toCharArray()) {
                if (map.containsKey(c)) {
                    answer[i] += map.get(c);
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}