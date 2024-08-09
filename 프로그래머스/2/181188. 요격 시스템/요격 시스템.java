import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1] - o2[1]; 
        });
        
        int x = 0;
        for (int[] t : targets) {
            if (x <= t[0]) {
                x = t[1];
                answer++;
            }
        }
        return answer;
    }
}
