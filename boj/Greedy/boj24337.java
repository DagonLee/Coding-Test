package boj.Greedy;

import java.io.*;
import java.util.*;
public class boj24337 {
    /*
     * 240228 20:08
     * 240229 10:02 => fail
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n, a, b;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        boolean[] checked = new boolean[n];
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        // a,b 중 큰 수에 맞춰서 쵀대 높이가 정해진다.
        // a 가 크다면 1 ~ a 까지 입력하고 뒤에서 부터 1 ~ b - 1까지 입력한다.
        // b가 크다면 1 ~ a-1 까지 입력하고 뒤에서 부터 1~ b까지 입력

        Deque<Integer> heights = new ArrayDeque<>();
        if(a >= b){
            for(int i = 1; i<= a; i++){
                heights.addLast(i);
            }
            if(b - 1 > 0){
                for(int i = b - 1; i >= 1; i--){
                    heights.addLast(i);
                }
            }
        }
        else{
            if(a - 1 > 0){
                for(int i = 1; i<= a - 1; i++){
                    heights.addLast(i);
                }
            }
            for(int i = b; i >= 1; i--){
                heights.addLast(i);
            }
        }
        if(heights.size() < n){
            int ones = n - heights.size();
            int first = heights.pollFirst();
            for(int i = 1; i <= ones; i++){
                heights.addFirst(1);
            }
            heights.addFirst(first);
        }
        for(int h : heights){
            sb.append(h+ " ");
        }
        if(heights.size() > n){
            System.out.println("-1");
        }
        else{
            System.out.println(sb.toString());
        }
    }
}
