package boj.Dynamic_programming;

import java.io.*;
import java.util.*;

public class boj12865 {
    /*
     * 기본적인 배낭문제
     * 2차원 배열 방식이 아닌 1차원 배열 방식을 학습하여 해결
     * 학습 블로그 : https://sskl660.tistory.com/88
     * 
     * 해결방법
     * 각 물품을 순회하며 물품의 무게당 최대 가치를 1차원 배열에 저장한다.
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k + 1];
        int[][] data = new int[n + 1][2];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            data[i][0] = weight;
            data[i][1] = value;
        }
        for(int i = 1; i <= n; i++){
            for(int j = k; j >= data[i][0]; j--){
                dp[j] = Math.max(dp[j], dp[j - data[i][0]] + data[i][1]);
            }
        }
        System.out.println(dp[k]);
    }
}
