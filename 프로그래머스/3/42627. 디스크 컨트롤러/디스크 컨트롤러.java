import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int time = 0;
        int index = 0;
        int endJobCount = 0;
        while (endJobCount < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= time) {
                pq.offer(jobs[index]);
                index++;
            }
            if (!pq.isEmpty()) {
                int[] currentJob = pq.poll();
                time += currentJob[1];
                answer += (time - currentJob[0]); // 끝난 시간 - 기다리기 시작한 시간 
                endJobCount += 1;
            } else {
                time = jobs[index][0];
            }
        }
        return answer / jobs.length;
        
    }
}