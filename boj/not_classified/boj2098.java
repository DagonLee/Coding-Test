package boj.not_classified;

import java.io.*;
import java.util.*;

public class boj2098 {
    static int n, fullBit;
	static int[][] w;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		fullBit = (1<<n) -1;
		w = new int[n][n];
		dp = new int[n][fullBit];
		for(int i=0; i<n; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(tsp(0,1)); 
	}
	
	static int tsp(int x, int check) {
        
		if(check == fullBit) {
			if(w[x][0] == 0) return 16000001; 
			else return w[x][0]; 
		}
        
		if(dp[x][check] != -1) return dp[x][check];
        
		dp[x][check] = 16000001;
        
		for(int i=0; i<n; i++) {
			int next = check | (1<<i); 
            
			if(w[x][i] ==0 || (check & (1<<i)) != 0) continue;
			
			dp[x][check] = Math.min(dp[x][check], tsp(i, next) + w[x][i]);
		}
		
		return dp[x][check];
	}
}
