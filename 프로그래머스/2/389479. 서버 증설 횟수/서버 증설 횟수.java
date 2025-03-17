import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int server = 1;
        for (int i = 0; i < players.length; i++) {
            int currentPlayer = players[i];
            
            while (!pq.isEmpty() && pq.peek() <= i) {
                server -= 1;
                pq.poll();
            }
            int remain = currentPlayer - server * m;
            if (remain < 0) continue; // 안 늘려도됨
            
            while (remain >= 0) {
                answer += 1;
                server += 1; // 서버를 하나 증설하면
                remain -= m; // m 명 커버 가능
                pq.offer(i + k); // 증설 수 만큼 pq에 넣고 현재 시간에서 k 시간 후에 서버 감축
                 
            }
        }
        
        return answer;
    }
}