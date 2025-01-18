import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] students = new int[30];
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < 28; i++) {
            hashSet.add(Integer.parseInt(br.readLine()));
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= 30; i++) {
            if (!hashSet.contains(i)) pq.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        System.out.println(sb);
    }
}