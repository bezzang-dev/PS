import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int start = 1;
        int end = 100000;
        
        while (start <= end) {
            int level = (start + end) / 2;
            long total = 0;
            
            // check
            for (int i = 0; i < diffs.length; i++) {
                int diff = diffs[i];
                int timeCur = times[i];
                
                if (diff <= level) {
                    total += timeCur;
                } else {
                    if (i == 0) {
                        total += (long) (diff - level) * timeCur + timeCur;
                    } else {
                        total += (long) (diff - level) * (times[i - 1] + timeCur) + timeCur;   
                    }
                }
            }
            
            if (total <= limit) {
                answer = (int) level;
                end = level - 1;
            } else {
                start = level + 1;
            }
        }
        
        return answer;
    }
}