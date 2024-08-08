import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < enemy.length;i++) {
            if (k > 0) {
                pq.offer(enemy[i]);
                k -= 1;
            } else {
                int currentEnemy = enemy[i];
                if (pq.peek() < currentEnemy) {
                    pq.offer(currentEnemy);
                    currentEnemy = pq.poll();
                }
                if (currentEnemy <= n) {
                    n -= currentEnemy;
                } else {
                    break;
                }  
            } answer += 1;
            
        }
        
        return answer;
    }
}