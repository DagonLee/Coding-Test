
import java.util.*;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            q.add(arr[i]);
        }
        int prev = -1;
        ArrayList<Integer> lst = new ArrayList<>();
        while(!q.isEmpty()){
            int now = q.poll();
            if(prev == -1 || prev != now){
                prev = now;
                lst.add(now);
            }
        }
        
        int[] answer = new int[lst.size()];
        for(int i = 0; i < lst.size(); i++){
            answer[i] = lst.get(i);
        }
        return answer;
    }
}