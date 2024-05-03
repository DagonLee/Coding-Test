package boj.Implementation;

import java.io.*;
import java.util.*;

public class boj2841 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, p;
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer>[] pQueues = new PriorityQueue[7];
        for(int i = 1; i <= 6; i++){
            pQueues[i] = new PriorityQueue<>();
        }
        int moves = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int line = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            
            // 누른 플랫이 없는 경우
            if(pQueues[line].isEmpty()){
                pQueues[line].add(-num);
                moves++;
            }
            // 누른 플랫이 있는 경우
            else{
                
                int last = pQueues[line].peek() * -1;
                // 현재 누른 플랫보다 높은 자리를 누르는 경우
                if(last < num){
                    pQueues[line].add(-num);
                    moves++;
                }
                // 현재 누른 플랫보다 낮은 자리를 누르는 경우
                else if(last > num){
                    while(!pQueues[line].isEmpty() &&(pQueues[line].peek() * -1) > num){
                        pQueues[line].poll();
                        moves++;
                    }
                    if(pQueues[line].isEmpty() || (pQueues[line].peek() * -1) != num){
                        pQueues[line].add(-num);
                        moves++;
                    }
                }
            }
            
        }
        System.out.println(moves);
    }
}
