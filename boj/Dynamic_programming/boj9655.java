package boj.Dynamic_programming;

import java.io.*;
public class boj9655 {
    static int turn = 0;
    static int n;
    static void dfs(int now, int p){
        if(now == n){
            turn = p;
            return;
        }
        if(now > n){
            return;
        }
        dfs(now + 1, (p + 1) % 2);
        dfs(now + 3, (p + 1) % 2);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if(n >= 3){
            dp[3] = 1;
        }
        for(int i = 1; i < n; i++){
            if(i + 1 <= n && dp[i + 1] == 0){
                dp[i + 1] = (dp[i] + 1) % 2;
            }
            if(i + 3 <= n && dp[i + 3] == 0){
                dp[i + 3] = (dp[i] + 1) % 2;
            }
        }
        if(dp[n] == 1){
            System.out.println("SK");
        }
        else{
            System.out.println("CY");
        }
    }
}
