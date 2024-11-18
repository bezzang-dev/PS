import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return 5 * cities.length;
        }
        
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
        
        LinkedList<String> q = new LinkedList<>();
        for (String city : cities) {
            if (q.size() <= cacheSize && q.contains(city)) { // 다시 캐싱
                q.remove(city); 
                q.offer(city);
                answer += 1;
            } else if (q.size() < cacheSize && !q.contains(city)) { // 바로 캐싱
                q.offer(city);
                answer += 5;
            } else if (q.size() >= cacheSize && !q.contains(city)) { // 마지막꺼 지우고 새로 캐싱
                q.poll();
                q.offer(city);
                answer += 5;
            } 
        }
        return answer;
    }
}