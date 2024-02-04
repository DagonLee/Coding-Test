package boj.Greedy;

import java.io.*;
import java.util.*;
public class boj8708 {
    /*
     * start 240204 09:09
     * 문제
     * 할 수 있는 선택지
     * 1. 주식 구매
     * 2. 주식 판매
     * 3. 아무 것도 안함
     * 최대 이익을 계산
     * 
     * 해결방법
     * 마지막 날을 최댓값으로 시작하여 뒤에서 부터 처음으로 탐색
     * 최댓값 보다 작다면 차이를 이익에 +, 크다면 최댓값 갱신
     * 
     * 결과
     * 1st try : 240204 09:24 => fail
     * Guessed Integer Value limit exceed error
     * 2nd try : 240204 09:31 => success
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                nums[j] = Integer.parseInt(st.nextToken());
            }
            int max_price = nums[n - 1];
            long ans = 0;
            for(int j = n - 2; j >= 0; j--){
                if(nums[j] >= max_price){
                    max_price = nums[j];
                }
                else{
                    ans += (max_price - nums[j]);
                }
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb.toString());
    }
}
