package boj.Dynamic_programming;

import java.io.*;
import java.util.StringTokenizer;

public class boj2631 {
    /*
     * start 240224 18:48
     * 
     * 문제
     * n명의 아이들에 대한 번호가 주어진다.
     * 오름차순으로 서야할때
     * 1~n의 번호가 주어지고, 번호 순서대로 정렬하는데 아이들을 옮기는 최수 수를 출력하라.
     * 
     * 해결방법
     * 오름차순이 되야한다.
     * 각 번호별로 뒤에 있는 아이들의 번호 보다 현재 자신의 번호보다 작은 경우를 센다.
     * ex) 3 7 5 2 6 1 4
     * 3 : 1,2 => 2개
     * 7 : 5개
     * 5 : 3개
     * 2 : 1개
     * 6 : 2개
     * 1 : 0개
     * 4 : 0개
     * 19:06 해결방법 생각 못함
     * 다른 풀이 참고
     * 최장 증가 부분수열 찾고 n으로 빼준다.
     * 
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];
        for(int i = 1; i <= n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dp[i] = 1;
            for(int j = 1; j <= i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for(int i = 1; i<= n; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(n - max);
    }

}
