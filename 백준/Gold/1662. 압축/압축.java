import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] sentence = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sentence.length; i++) {
            if (sentence[i] != ')') {
                if (Character.isDigit(sentence[i])) {
                    stack.push(sentence[i] - '0'); // 숫자는 숫자 자체로 스택에 푸시
                } else {
                    stack.push(-1); // '('를 나타내기 위해 -1을 스택에 푸시
                }
            } else {
                int cnt = 0;
                while (stack.peek() != -1) { // '(' 를 만날때까지
					int top = stack.pop();
                    if (top == -2) { // -2가 나오면 다음 pop은 여태까지의 계산된 길이가 나옴
                        int len = stack.pop();
                        cnt += len;
                    } else cnt++; // 문자들을 차례로 1씩 증가
                }
                stack.pop(); // '(' 제거
                int k = stack.pop(); // 반복 횟수
                cnt *= k;
                stack.push(cnt); // 내부 괄호의 길이를 스택에 푸시
				stack.push(-2); // 다음 -2가 나오면 다음 pop은 위 cnt 길이가 나옴
            }
        }

        int answer = 0;
        while (!stack.isEmpty()) {
			if (stack.peek() == -2) { // -2 를 만나면 그 다음 pop은 여태 누적된 괄호 합이 나온다
				stack.pop();
				answer += stack.pop();
			} else {
				stack.pop();
				answer++; // 괄호 밖의 남은 문자들의 길이를 1씩 더함
			}
        }
        System.out.println(answer);
    }
}
