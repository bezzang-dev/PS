import java.util.*;

class Solution {
    
    static String[][] staticPark;
    
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        staticPark = park;
        
        Arrays.sort(mats);
        
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length; j++) {
                if (park[i][j].equals("-1")) {  // 빈 자리인 경우
                    // 큰 돗자리부터 깔 수 있는지 확인
                    for (int k = mats.length - 1; k >= 0; k--) {
                        int size = mats[k];
                        
                        // 경계 밖으로 나가지 않는지 확인
                        if (i + size <= park.length && j + size <= park[0].length) {
                            int tmp = putMats(size, i, j);
                            if (tmp != -1) { // 돗자리를 깔 수 있으면 최댓값 갱신
                                answer = Math.max(answer, tmp);
                                break; // 더 작은 돗자리는 볼 필요가 없으므로 break
                            }
                        }
                    }
                }
            }
        }    
        return answer;
    }
    
    int putMats(int matSize, int startRow, int startCol) {
        for (int i = startRow; i < startRow + matSize; i++) {
            for (int j = startCol; j < startCol + matSize; j++) {
                if (!staticPark[i][j].equals("-1")) {
                    return -1;
                }
            }
        }
        return matSize;
        
    }
}