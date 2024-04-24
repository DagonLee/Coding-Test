package boj.Dynamic_programming;

import java.io.*;
import java.util.*;

public class boj2302 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int ans = 1;
        int start = 0;
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            int end = Integer.parseInt(br.readLine());
            ans *= dp[end - start - 1];
            start = end;
        }
        ans *= dp[n - start];
        System.out.println(ans);
    }
}
