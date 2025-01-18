import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int test = 0; test < tc; test++) {

            String functions = br.readLine();
            int size = Integer.parseInt(br.readLine());
            String strArr = br.readLine();
            Deque<Integer> deque = new ArrayDeque<>();
            if (size > 0) {
                String[] tmp = strArr.substring(1, strArr.length() - 1).split(",");
                for (String s : tmp) deque.offer(Integer.parseInt(s));
            }
            boolean isReversed = false;
            boolean isError = false;

            for (int i = 0; i < functions.length(); i++) {
                char function = functions.charAt(i);

                switch (function) {
                    case 'R':
                        isReversed = !isReversed;
                        break;
                    case 'D':
                        if (deque.isEmpty()) {
                            isError = true;
                            break;
                        }
                        if (isReversed) {
                            if (deque.pollLast() == null) {
                                isError = true;
                            }
                        } else {
                            if (deque.pollFirst() == null) {
                                isError = true;
                            }
                        }
                        break;
                }
                if (isError) break;
            }
            if (isError) {
                sb.append("error\n");
            } else {

                if (deque.isEmpty()){
                    sb.append("[]").append("\n");
                }

                else {
                    sb.append("[");
                    if (isReversed) {
                        while (!deque.isEmpty()) {
                            sb.append(deque.pollLast()).append(",");
                        }
                    } else {
                        while (!deque.isEmpty()) {
                            sb.append(deque.pollFirst()).append(",");
                        }
                    }
                    sb.deleteCharAt(sb.length() - 1).append("]").append("\n");
                }
            }
        }

        System.out.println(sb);
    }

}