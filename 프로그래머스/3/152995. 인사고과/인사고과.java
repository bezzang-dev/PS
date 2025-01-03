import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        int wanhoSum = wanho[0] + wanho[1];
        // 핵심!!! 동료 평가 점수는 오름차순으로!!
        // 내림차순으로 하면, 가장 높은 점수가 맨 앞으로 가기 때문에 뒤에서 오는 인덱스는 모두 인센티브를 못 받는 사원이 되버림
        // 따라서 인센티브를 못 받는 사원을 걸러낼 수 없음
        // 오른차순으로 하면, 근무 태도 점수를 따질 필요 없이 가장 높은 동료 평가 점수를 업데이트 하면서 석차를 따질 수 있음 
        Arrays.sort(scores, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        int rank = 1;
        int maxPeerMeasurePoint = 0;
        for (int i = 0; i < scores.length; i++) {
            int[] current = scores[i];
            
            if (current[1] < maxPeerMeasurePoint) {
                if (current.equals(wanho))
                    return -1;
            }
            else {
                maxPeerMeasurePoint = Math.max(current[1], maxPeerMeasurePoint);
                int currentSum = current[0] + current[1];
                if (wanhoSum < currentSum)
                    rank += 1;
            }
        }
        
        return rank;
        
    }
}