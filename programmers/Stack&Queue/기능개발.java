import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            q.add(progresses[i]);
        }
        int idx = 0;
        int cnt = 0;
        double accumTime = 0;
        ArrayList<Integer> lst = new ArrayList<>();
        while(!q.isEmpty()){
            int now = q.poll();
            double time = Math.ceil((double)(100 - now) / (double)speeds[idx]);
            if(idx == 0){
                accumTime = time;
                cnt ++;
                idx ++;
                continue;
            }
            if(accumTime < time){
                lst.add(cnt);
                accumTime = time;
                idx ++;
                cnt = 1;
            }
            else{
                cnt ++;
                idx ++;
            }
        }
        if(cnt != 0){
            lst.add(cnt);
        }
        int[]ans = new int[lst.size()];
        for(int i = 0; i < lst.size(); i++){
            ans[i] = lst.get(i);
        }
        return ans;
    }
}