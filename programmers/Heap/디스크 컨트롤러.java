import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (t1, t2) ->  t1[0] - t2[0]);
        System.out.println(jobs[0][0]);
        int answer = 0;
        int cnt = 0;
        int index = 0;
        int tot = 0;
        int cur = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((t1,t2)-> t1[1] - t2[1]);
        while( cnt < jobs.length){
            while(index < jobs.length && jobs[index][0] <= cur){
                pq.add(jobs[index++]);
            }
            if(pq.isEmpty()){
                cur = jobs[index][0];
            }
            else{
                int[] now = pq.poll();
                tot += now[1] + cur - now[0];
                cur += now[1];
                cnt++;
            }
        }
        return tot/ jobs.length;
    }
}