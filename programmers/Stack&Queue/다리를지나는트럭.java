//https://school.programmers.co.kr/learn/courses/30/lessons/42583?language=java
import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int truck_num = truck_weights.length;
        int cur_truck_idx = 0;
        int cur_weight = 0;
        Queue <Integer> q = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){
            q.add(0);
        }
        // 1. 큐를 다리로 생각, 첫 트럭을 먼저 큐에 넣는다. 
        // 2. 큐에 차례로 허용 무게를 넘지 않을 경우 트럭을 큐에 넣는다.
        // 2-1. 단, 무게를 넘는 경우와 이미 트럭을 다 넣은 경우 0을 넣는다.
        int time = 0;
        int pass_cnt = 0;
        while(!q.isEmpty()&& pass_cnt != truck_num){
            time ++;
            int now = q.poll();
            cur_weight -= now;
            if(now > 0){
                pass_cnt ++;
            }
            if(cur_truck_idx < truck_num){
                int next = truck_weights[cur_truck_idx];
                if(cur_weight + next <= weight){
                    cur_weight += next;
                    cur_truck_idx ++;
                    q.add(next);
                }
                else{
                    q.add(0);
                }
            }
            else{
                q.add(0);
            }
        }
        return time;
    }
}