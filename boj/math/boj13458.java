package boj.math;

import java.io.*;
import java.util.*;
public class boj13458 {
    /*
     * 문제를 잘못이해하여 5번 시도
     * 총 감독관은 1명이 필수
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int b, c;
        int[] rooms = new int[n];
        long tot = 0L;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            rooms[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            if(rooms[i] > b){
                rooms[i] -= b;
                tot += (Math.ceil((double) rooms[i]/ c));
            }
            tot++;
        }
        System.out.println(tot);
    }
}
