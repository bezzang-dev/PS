import java.util.Arrays;

class Solution {
    
    // A가 남길 수 있는 최대 흔적 (40개 물건 * 3)
    private static final int MAX_A_TRACE = 120;
    
    // 무한대를 의미하는 큰 값 (m의 최대값 120, b_cost의 최대값 3, 
    // 모든 물건(40)을 B가 훔쳐도 120이므로, 121보다 크면 충분합니다.)
    // 여기서는 넉넉하게 987654321을 사용합니다.
    private static final int INFINITY = 987654321;

    public int solution(int[][] info, int n, int m) {
        
        // 1. DP 테이블 초기화
        // dp[a] = A가 정확히 'a'개의 흔적을 남겼을 때, B가 남기는 흔적의 '최소' 개수
        int[] dp = new int[MAX_A_TRACE + 1];
        
        // dp[0] = 0 (시작 상태)
        // 나머지는 모두 도달 불가능한 상태(무한대)로 초기화
        Arrays.fill(dp, INFINITY);
        dp[0] = 0;

        // 2. DP 테이블 채우기 (모든 물건에 대해 반복)
        for (int[] item : info) {
            int a_cost = item[0]; // A가 이 물건을 훔칠 때의 흔적
            int b_cost = item[1]; // B가 이 물건을 훔칠 때의 흔적

            // ★ 중요: 1차원 DP 배열을 갱신할 때는 뒤에서부터 순회해야
            // 이번 라운드(item)에서 갱신된 값이 다음 계산에 영향을 주지 않습니다.
            // (즉, 각 물건을 한 번만 사용하도록 보장)
            for (int a = MAX_A_TRACE; a >= a_cost; a--) {
                // A가 a개의 흔적을 만드는 방법은 2가지
                
                // Case 1: B가 이 물건을 훔친다.
                // A는 'a'개 흔적 그대로, B의 흔적은 'dp[a] + b_cost'가 됨.
                // (단, dp[a]가 INFINITY면, 이 상태는 여전히 INFINITY)
                int b_steals_cost = (dp[a] == INFINITY) ? INFINITY : dp[a] + b_cost;
                
                // Case 2: A가 이 물건을 훔친다.
                // A가 'a'개 흔적을 만들려면, 이전 상태는 'a - a_cost'여야 함.
                // B의 흔적은 이전 상태의 B 흔적 'dp[a - a_cost]'와 같음.
                int a_steals_cost = dp[a - a_cost];
                
                // 두 경우 중 B의 흔적이 '최소'가 되는 쪽을 선택
                dp[a] = Math.min(b_steals_cost, a_steals_cost);
            }

            // A가 이 물건을 훔쳐서는 'a'를 만들 수 없는 경우 (a < a_cost)
            // 이 상태들은 무조건 B가 훔쳐야만 갱신될 수 있음.
            for (int a = a_cost - 1; a >= 0; a--) {
                if (dp[a] != INFINITY) {
                    dp[a] = dp[a] + b_cost;
                }
            }
        }

        // 3. 정답 찾기
        // A가 붙잡히지 않는 범위 (a < n) 내에서
        // B도 붙잡히지 않는 (dp[a] < m)
        // '가장 작은 a'를 찾는다.
        for (int a = 0; a < n; a++) {
            if (dp[a] < m) {
                return a; // 최초로 찾은 a가 A의 최소 흔적
            }
        }

        // 4. 불가능한 경우
        // 루프를 다 돌아도 조건을 만족하는 'a'가 없으면 -1 반환
        return -1;
    }
}