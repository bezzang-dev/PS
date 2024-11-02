import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int healthTime = bandage[0];
        int healthAmount = bandage[1];
        int serviceHealth = bandage[2];
        int maxHealth = health;

        int attackIdx = 0;
        int cnt = 0;
        for (int time = 1; time <= attacks[attacks.length - 1][0]; time++) {
            int[] attack = attacks[attackIdx];
            int attackTime = attack[0];
            int damage = attack[1];
            
            // 공격 시간이면
            if (attackTime == time) {
                health -= damage;
                cnt = 0;
                attackIdx += 1;
                if (health <= 0) { // 죽으면
                    return -1;
                }
                continue;
            }
            cnt += 1;
            health += healthAmount;
            if (cnt == healthTime) { // 연속 성공 조건
                health += serviceHealth;
                cnt = 0;
            }

            // 체력이 넘어가면 최대 체력으로 고정
            if (maxHealth < health) {
                health = maxHealth;
            }
        }

        return health;
    }
}
