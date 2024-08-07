class Solution {
       public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];  
        int[][] triangle = new int[n][n];  
        
        int num = 1;  
        int row = -1, col = 0;  
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // 아래 -> 오른쪽 -> 왼쪽 대각선 순서이므로 3의 나머지로 방향 결정
                if (i % 3 == 0) {  // 아래로
                    row++;
                } else if (i % 3 == 1) {  // 오른쪽으로
                    col++;
                } else {  // 왼쪽 대각선으로
                    row--;
                    col--;
                }
                triangle[row][col] = num++;
            }
        }
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = triangle[i][j];
            }
        }
        
        return answer;
       }
}

/**
1
2 9
3 10 8
4 5 6 7
*/
    