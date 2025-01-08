class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        var d2 = Math.pow(d, 2);
        
        for (int a = 0; a * k <= d; a++) {
            long a2 = (long)Math.pow(a * k, 2);
            long maxB = (long)Math.sqrt(d2 - a2) / k;
            answer += maxB + 1;
        }
        
        return answer;
    }
}