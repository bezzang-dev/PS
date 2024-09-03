import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int n = a.length;
        int[] count = new int[n];
        for (int num : a) {
            count[num] += 1;
        }
        
        for(int num = 0; num < n; num++) {
            if (count[num] <= answer) continue; // 이미 등장한 숫자보다 더 빈도가 적거나 같은 경우
            int length = 0;
            for (int i = 0; i < n - 1; i++) {
                if ((a[i] != a[i + 1]) && (a[i] == num || a[i + 1] == num)) {
                    length += 1;
                    i += 1;
                }
            }
            answer = Math.max(length, answer);
        }
        return answer * 2;
    }
}
