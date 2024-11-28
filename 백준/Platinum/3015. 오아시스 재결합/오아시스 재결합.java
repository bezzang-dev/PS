import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int height;
        long count;
    
        public Node(int height, long count) {
            this.height = height;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Node> stack = new Stack<>();
        long answer = 0;
        for (int current : arr) {
            long count = 1;
            while (!stack.isEmpty() && stack.peek().height <= current) {
                Node prev = stack.pop();
                answer += prev.count;
                if (prev.height == current) count += prev.count;
            }
            if (!stack.isEmpty()) answer += 1;
            stack.push(new Node(current, count));
        }
        System.out.println(answer);

    }
}