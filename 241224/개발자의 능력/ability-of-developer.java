import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[12];     // 12명 능력치
    static boolean[] used = new boolean[12];  
    static int[] teamSums = new int[4]; // 4팀 각각의 능력 합
    static int bestDiff = Integer.MAX_VALUE; // 최소 차를 갱신해가며 관리
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 12명 능력치 입력
        for (int i = 0; i < 12; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
        
        // 백트래킹 시작
        makeTeam(0, 0);
        
        // 결과 출력
        System.out.println(bestDiff);
    }
    
    /**
     * teamIndex 번째 팀을 구성한다.
     * 현재까지 팀 번호(teamIndex)는 0 ~ 3
     * chosenCount는 한 팀에 대해 지금까지 선택한 멤버 수(0~3).
     * 
     * - teamIndex == 4까지 도달하면 (즉 4팀 완성), 차이 계산 & bestDiff 갱신
     */
    static void makeTeam(int teamIndex, int startIndex) {
        // base condition: 4팀 다 구성됨
        if (teamIndex == 4) {
            // 4팀 모두의 합이 teamSums[]에 들어있음
            // 최댓값, 최솟값 구해 차이를 갱신
            int maxVal = Integer.MIN_VALUE;
            int minVal = Integer.MAX_VALUE;
            
            for (int sum : teamSums) {
                maxVal = Math.max(maxVal, sum);
                minVal = Math.min(minVal, sum);
            }
            bestDiff = Math.min(bestDiff, maxVal - minVal);
            return;
        }
        
        // 3명을 고르는 백트래킹
        pickMembers(teamIndex, 0, startIndex);
    }
    
    /**
     * 백트래킹으로 해당 teamIndex 팀에 3명 선택
     * count: 현재까지 몇 명을 골랐는지
     * start: 어디서부터 새 멤버를 고를지 (조합의 시작 인덱스)
     */
    static void pickMembers(int teamIndex, int count, int start) {
        // 한 팀에 3명을 다 골랐으면, 다음 팀으로 이동
        if (count == 3) {
            // 다음 팀 구성
            makeTeam(teamIndex + 1, 0);
            return;
        }
        
        // 아직 3명을 채우지 못했으므로, start ~ 11 범위에서 골라간다
        for (int i = start; i < 12; i++) {
            if (!used[i]) {
                used[i] = true;
                teamSums[teamIndex] += arr[i];
                
                // 다음 사람 고르기
                pickMembers(teamIndex, count + 1, i + 1);
                
                // 백트래킹 복구
                used[i] = false;
                teamSums[teamIndex] -= arr[i];
            }
        }
    }
}
