import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            list.get(road[0]).add(road[1]);
            list.get(road[1]).add(road[0]);
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(destination);
        
        boolean[] isVisited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        distance[destination] = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int currentDistance = distance[current];   
            
            ArrayList<Integer> currentRoads = list.get(current);
            for (int road : currentRoads) {
                if (distance[road] == -1) {
                    distance[road] = currentDistance + 1;
                    queue.offer(road);
                }
            }       
        }
        
        int[] answer = new int[sources.length];
        for (int i = 0 ; i < answer.length; i++) {
            answer[i] = distance[sources[i]];
        }
        
        return answer;
    }
}