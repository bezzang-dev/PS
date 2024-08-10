import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfComputers = Integer.parseInt(br.readLine());
        int numOfInputs = Integer.parseInt(br.readLine());
        
        List<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= numOfComputers; i++) {
            arr.add(new ArrayList<>());
        }
        
        for (int i = 0; i < numOfInputs; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a); // 양방향 연결
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1); 
        boolean[] isVisited = new boolean[numOfComputers + 1];
        isVisited[1] = true;
        int answer = 0;
        
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int e : arr.get(current)) {
                if (!isVisited[e]) {
                    q.offer(e);
                    isVisited[e] = true; // 방문 처리
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}