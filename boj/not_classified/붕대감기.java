package boj.not_classified;
// https://school.programmers.co.kr/learn/courses/30/lessons/250137
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int ans = health;
        int start = 0;
        int recover = bandage[1];
        for(int i = 0; i < attacks.length; i++){
            if(ans <= 0){
                return -1;
            }
            int attackTime = attacks[i][0];
            int damage = attacks[i][1];
            int max = Math.max(attackTime, start);
            int min = Math.min(attackTime, start);
            int loop = (max - min - 1) / bandage[0];
            int left = (max - min - 1) % bandage[0];
            ans += (loop * bandage[0] + left) * recover;
            ans += loop * bandage[2];
            if(ans > health){
                ans = health;
            }
            start = max;
            ans -= damage;
            
        }
        if(ans <= 0){
            return -1;
        }
        return ans;
    }
}