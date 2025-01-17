import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> queue = new LinkedList<>();
        int card = 1;
        for (int i = N - 1; i >= 0; i--) {
            int value = arr[i];
            if (value == 1) {
                queue.offerLast(card);
            } else if (value == 2) {
                int tmp = queue.pollLast();
                queue.offerLast(card);
                queue.offerLast(tmp);
            } else if (value == 3) {
                queue.offerFirst(card);
            }
            card += 1;

        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.pollLast()).append(" ");
        }

        System.out.println(sb);

    }

}
