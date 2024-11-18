import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[][] fatigueTable = {
            {1, 1, 1},  // 다이아몬드 곡괭이
            {5, 1, 1},  // 철 곡괭이
            {25, 5, 1}  // 돌 곡괭이
        };
        // 전부 못 부수는 경우 끝에 광물 버리기
        int sumPicks = 0;
        for (int pick : picks) {
            sumPicks += pick;
        }

        // 총 곡괭이가 처리할 수 있는 최대 광물 개수
        int maxMinerals = sumPicks * 5;

        // 광물이 곡괭이로 처리할 수 있는 최대치보다 많다면, 끝에 있는 광물을 버림
        if (minerals.length > maxMinerals) {
            minerals = Arrays.copyOf(minerals, maxMinerals);
        }


        // 광물을 5개씩 묶어 계산하기 위해 리스트로 나눕니다.
        List<int[]> groupedMinerals = new ArrayList<>();
        for (int i = 0; i < minerals.length; i += 5) {
            int[] count = new int[3]; // [다이아몬드, 철, 돌]
            for (int j = i; j < i + 5 && j < minerals.length; j++) {
                if (minerals[j].equals("diamond")) count[0]++;
                else if (minerals[j].equals("iron")) count[1]++;
                else if (minerals[j].equals("stone")) count[2]++;
            }
            groupedMinerals.add(count);
        }

        // 가장 피로도가 높은 그룹을 먼저 처리하기 위해 정렬
        groupedMinerals.sort((a, b) -> (b[0] * 25 + b[1] * 5 + b[2]) - (a[0] * 25 + a[1] * 5 + a[2]));

        // 각 곡괭이를 순서대로 사용하여 그룹 처리
        for (int[] group : groupedMinerals) {
            if (picks[0] > 0) { // 다이아몬드 곡괭이 사용
                picks[0]--;
                answer += group[0] * fatigueTable[0][0] + group[1] * fatigueTable[0][1] + group[2] * fatigueTable[0][2];
            } else if (picks[1] > 0) { // 철 곡괭이 사용
                picks[1]--;
                answer += group[0] * fatigueTable[1][0] + group[1] * fatigueTable[1][1] + group[2] * fatigueTable[1][2];
            } else if (picks[2] > 0) { // 돌 곡괭이 사용
                picks[2]--;
                answer += group[0] * fatigueTable[2][0] + group[1] * fatigueTable[2][1] + group[2] * fatigueTable[2][2];
            } else {
                break; // 사용할 곡괭이가 없으면 종료
            }
        }

        return answer;
    }
}
