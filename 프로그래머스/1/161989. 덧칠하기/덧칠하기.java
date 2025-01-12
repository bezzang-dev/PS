import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int lastIdx = 0;
        for (int s : section) {
            if (lastIdx < s) {
                lastIdx = s + m - 1;
                answer += 1;
            }
        }
        return answer;
    }
}