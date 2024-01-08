//https://school.programmers.co.kr/learn/courses/30/lessons/42626?language=java
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville){
            pq.add(i);
        }
        while(pq.size() > 1 && pq.peek() < K){
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + second * 2);
            answer ++;
        }
        if(pq.peek() < K){
            return -1;
        }
        return answer;
    }
}