package boj.Implementation;

import java.io.*;
import java.util.*;

public class boj13335 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, w, l;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int time = 0;
        int cur = 0;
        int curWeight = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();

        int[] cars = new int[n];
        for(int i = 0; i < n; i++){
            cars[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < w; i++){
            q.addLast(0);
        }
        while(!q.isEmpty()){
            int val = q.pollFirst();
            curWeight -= val;
            time++;
            if(cur < n && curWeight + cars[cur] > l){
                q.addLast(0);
            }
            else if(cur < n){
                q.addLast(cars[cur]);
                curWeight += cars[cur];
                cur++;
            }
        }
        System.out.println(time);
    }
}
