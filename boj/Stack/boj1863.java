package boj.Stack;

import java.io.*;
import java.util.*;
public class boj1863 {
    /*
     * start 240218 14:18
     * 
     * 문제
     * 스카이라인을 보고 건물의 최소 예상 개수를 구하라
     * 
     * 해결방법
     * 스택을 사용하여 해결
     * 
     * 주어진 입력의 높이가 1인 경우
     * 스택이 스택의 마지막 값이 1인 경우 넘어간다.
     * 스택에 스택의 마지막 값이 1아닌 경우 1이 나올때까지 건물 갯수 + 1 하고 스택을 pop한다.
     * 
     * 주어진 입력의 높이가 1이 
     * 24:47 => reference 참조
     * 스택을 통해서 높이가 작아진다면 건물 + 1 
     * 높이가 같다면 continue
     * 
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        int[] lst = new int[n + 1];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x, y;
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            lst[i] = y;            
        }
        for(int i = 0; i <= n; i++ ){
            while(!stack.isEmpty() && stack.getLast() > lst[i]){
                ans ++;
                stack.pollLast();
            }
            if(!stack.isEmpty() && stack.getLast() == lst[i]){
                continue;
            }
            stack.offerLast(lst[i]);
        }
        System.out.println(ans);
    }
}
