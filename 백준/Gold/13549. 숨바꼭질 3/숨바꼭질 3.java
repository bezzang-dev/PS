import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int subin = Integer.parseInt(st.nextToken());
        int sister = Integer.parseInt(st.nextToken());

        if (subin >= sister) { // 수빈이의 위치가 동생보다 크거나 같을 경우 걷기만 가능
            System.out.println(subin - sister);
            return;
        }

        Deque<int[]> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[100001];
        
        isVisited[subin] = true;
        queue.add(new int[]{subin, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentPoint = current[0];
            int currentTime = current[1];

            if (currentPoint == sister) { // 동생을 찾으면 바로 종료
                System.out.println(currentTime);
                return;
            }
            
            int next = currentPoint + 1;
            int back = currentPoint - 1;
            int tellpo = currentPoint * 2;
            if (tellpo < isVisited.length) {
                if (!isVisited[tellpo]) {
                    isVisited[tellpo] = true;
                    queue.addFirst(new int[]{tellpo, currentTime});
                }                
            } 
        
            if (0 <= back) {
                if (!isVisited[back]) {
                    isVisited[back] = true;
                    queue.addLast(new int[]{back, currentTime + 1});
                }                
            } 

            if (next < isVisited.length) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    queue.addLast(new int[]{next, currentTime + 1});
                }                
            } 
        }
    }
}