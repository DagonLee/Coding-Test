package boj.PriorityQueue;

import java.io.*;
import java.util.*;
public class boj11279 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int val = Integer.parseInt(br.readLine());
            if(val == 0){
                if(!pq.isEmpty()){
                    sb.append(-pq.poll()+"\n");
                }else{
                    sb.append("0\n");
                }
            }
            else{
                pq.offer(-val);
            }
        }
        System.out.println(sb.toString());
    }
}
