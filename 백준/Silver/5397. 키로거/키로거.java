import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            String sentence = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            for (int j = 0; j < sentence.length(); j++) {
                char current = sentence.charAt(j);
                if (current == '<') {
                    if (!left.isEmpty()) right.push(left.pop());
                } else if (current == '>') {
                    if (!right.isEmpty()) left.push(right.pop());
                } else if (current == '-') {
                    if (!left.isEmpty()) left.pop();
                } else {
                    left.push(current);
                }
            }
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}