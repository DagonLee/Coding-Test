package boj.Stack;
import java.io.*;
import java.util.*;
public class boj22866 {
    /*
     * start 240227 08:01
     * 문제
     * 건물들의 높이가 주어진다, 각 건물은 옆 건물의 높이가 자신의 높이보다 큰 건물들만 볼 수 있다.
     * 각 건물 별로 볼 수 있는 건물 중 가장 작은 번호로 출력하라.
     * 
     * 해결방법
     * 각 건물의 높이를 저장
     * 건물의 양 옆을 탐색 자신의 높이 보다 큰 건물을 찾는다.
     * 
     * 08:30 => 시간초과
     * 
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] heights = new int[n  + 1];
        int [] left = new int[n + 1];
        int [] right = new int[n + 1];
        int [] idxs = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            heights[i] = Integer.parseInt(st.nextToken());
        }
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            int curHeight = heights[i];
            while(!stack.isEmpty() && stack.getLast()[0] <= curHeight){
                stack.pollLast();
            }
            left[i] = stack.size();
            if(!stack.isEmpty()){
                idxs[i] = stack.getLast()[1];
            }
            stack.addLast(new int[]{heights[i], i});
        }
        stack = new ArrayDeque<>();
        for(int i = n; i >= 1; i--){
            int curHeight = heights[i];
            while(!stack.isEmpty() && stack.getLast()[0] <= curHeight){
                stack.pollLast();
            }
            right[i] = stack.size();
            if(!stack.isEmpty() && (Math.abs(i - idxs[i]) > Math.abs(stack.getLast()[1] - i) || idxs[i] == 0)){
                idxs[i] = stack.getLast()[1];
            }
            stack.addLast(new int[]{heights[i], i});
        }
        
        for(int i = 1; i <= n; i++){
            if((left[i] + right[i]) > 0){
                System.out.println((left[i] + right[i]) + " " + idxs[i]);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
