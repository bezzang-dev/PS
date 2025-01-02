class Solution {
    public long solution(int[] sequence) {
        int length = sequence.length;
        long[][] dp = new long[length][2];
        dp[0][0] = sequence[0];
        dp[0][1] = -sequence[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], 0) + sequence[i];
            dp[i][1] = Math.max(0, dp[i - 1][0]) - sequence[i]; 
        }
        long answer = 0;
        for (long[] arr : dp) {
            answer = Math.max(Math.max(arr[0], arr[1]), answer);
        }
        
        return answer;
    }
}