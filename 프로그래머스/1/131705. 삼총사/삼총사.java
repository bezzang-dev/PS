class Solution {

    private int answer;

    public int solution(int[] number) {
        answer = 0;
        backTracking(number, 0, 0, 0);
        return answer;
    }

    public void backTracking(int[] numbers, int start, int cnt, int sum) {
        if (cnt == 3) {
            if (sum == 0) {
                answer++;
            }
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            backTracking(numbers, i + 1, cnt + 1, sum + numbers[i]);
        }
    }
}
