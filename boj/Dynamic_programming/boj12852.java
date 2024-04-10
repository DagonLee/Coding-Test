package boj.Dynamic_programming;

import java.io.*;
import java.util.*;

public class boj12852 {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dp[i] = i;
        }
        for(int i = 2; i <= n; i++){
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i / 2]);
            }
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i / 3]);
            }
            dp[i] = Math.min(dp[i], dp[i - 1]) + 1;
        }
        System.out.println(dp[n] - 1);

        while(n != 0){
            System.out.print(n + " ");
            if(dp[n] == dp[n - 1] + 1){
                n -= 1;
            }
            else if(n % 2 == 0 && dp[n] == dp[n / 2] + 1){
                n /= 2;
            }
            else if(n % 3 == 0 && dp[n] == dp[n / 3] + 1){
                n /= 3;
            }
        }
    }
}
