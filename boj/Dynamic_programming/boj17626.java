package boj.Dynamic_programming;
import java.io.*;

public class boj17626 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] dp = new int[50001];
        dp[1] = 1;// i를 만드는 제곱 수의 수
        int n = Integer.parseInt(br.readLine());

        for(int i = 2; i <= n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                min = Math.min(min ,dp[i - (j * j)]);
            }
            dp[i] = (min + 1);
        }
        System.out.println(dp[n]);
    }
}
