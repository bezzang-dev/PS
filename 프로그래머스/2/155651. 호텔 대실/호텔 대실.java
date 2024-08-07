import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] times = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = convertToMinutes(book_time[i][0]);
            times[i][1] = convertToMinutes(book_time[i][1]) + 10; // 청소 시간 10분 추가
        }
        
        Arrays.sort(times, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<Integer> roomEndTime = new PriorityQueue<>();
        
        for (int[] time : times) {
            if (!roomEndTime.isEmpty() && roomEndTime.peek() <= time[0]) {
                roomEndTime.poll();
            }
            roomEndTime.offer(time[1]);
        }
        
        return roomEndTime.size();
    }
    
    public int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}