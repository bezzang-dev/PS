import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int maxX = s.length();
        
        for (int i = 0 ; i < maxX; i++) {
            if (check(s)) {
                answer += 1;
            }
            s = s.substring(1) + s.charAt(0);
        }
        return answer;
    }
    
    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (ch == ')' && top != '(') {
                    return false;
                } else if (ch == ']' && top != '[') {
                    return false;
                } else if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}