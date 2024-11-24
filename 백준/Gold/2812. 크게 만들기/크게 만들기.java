import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int max = -1;
        char[] arr = br.readLine().toCharArray();

        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty() && arr[i] > deque.getLast() && k > 0) {
                deque.removeLast();
                k -= 1;
            }
            deque.addLast(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        
        while (deque.size() > k) {
            sb.append(deque.poll());
        }
        System.out.println(sb);
    }
}