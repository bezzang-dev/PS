class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        int carry = 0;
        
        while (storey > 0) {
            int current = storey % 10 + carry;
            if (current > 5 || ((current == 5) && (storey / 10) % 10 >= 5)) {
                answer += (10 - current);
                carry = 1;
            } else {
                answer += current;
                carry = 0;
            }
                storey /= 10;
        }    
        if (carry > 0) {
            return answer + 1;
        }
        return answer;
    }
}