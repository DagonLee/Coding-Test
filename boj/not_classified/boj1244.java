package boj.not_classified;

import java.io.*;
import java.util.*;
public class boj1244 {
    static int[] switches;
    static int n;
    public static void man(int num){
        for(int i = 1; i <= n; i++){
            if(i % num == 0){
                switches[i] = (switches[i] + 1) % 2;
            }
        }
    }
    public static void woman(int num){
        int left = num;
        int right = num;
        while(left - 1 >= 1 && right + 1<= n && switches[left - 1] == switches[right + 1]){
            left--;
            right++;
        }
        for(int i = left; i <= right; i++){
            switches[i] = (switches[i] + 1) % 2;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        switches = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(type ==1){
                man(num);
            }
            else if(type == 2){
                woman(num);
            }
        }
        for(int i = 1; i <= n; i++){
            System.out.print(switches[i]);
            if(i % 20 == 0){
                System.out.println();
            }
            else if(i != n){
                System.out.print(" ");
            }
            
        }
        
    }
}
