package boj.math;
import java.io.*;
import java.util.*;

public class boj27172 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] hasTaken = new boolean[1000001]; 
        int[] player = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            hasTaken[num] = true;
            player[i] = num;
        }
        int[] score = new int[1000001];
        for(int i : player){
            for(int j = i * 2; j <= 1000000; j += i){
                if(hasTaken[j]){
                    score[i]++;
                    score[j]--;
                }
            }
        }
        for(int i : player){
            System.out.print(score[i] + " ");
        }
    }
}
