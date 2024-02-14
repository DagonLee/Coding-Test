package boj.BackTracking;
import java.io.*;
public class boj2775 {
    /*
     * start: 240214 17:29
     * 문제
     * a 층 b 호에 사는 사람 수는 a - 1 층의 1 ~ b호의 모든 사람 수 합이다.
     * 0층 i호에는 i명이 산다.
     * 
     * 입력
     * int t // 테스트 케이스 수
     * int k // k층
     * int n // n호
     * 
     * 해결방법
     * 1층 1호 => 1
     * 1층 2호 => 1 + 2
     * 1층 3호 => 1 + 2 + 3
     * 
     * 2층 1호 => 1
     * 2층 2호 => 1 + 1 + 2
     * 2층 3호 => 1 + 1 + 2 + 1 + 2 + 3
     * 
     * 3층 1호 => 2층 1호 : 1
     * 3층 2호 => 2층 1호 + 2호 : 1 + 1 + 1 + 2
     * 3층 3호 => 1 + 1 + 1 + 2 + 1 + 1 + 2 + 1 + 2 + 3
     * 
     * 재귀를 사용
     * backtrack
     * k, n 
     * k가 0 이면
     * 1 ~ n 의 누적 합을 반환
     * k가 1이 아니라면
     * k - 1, n 의 합
     * 
     */
    public static int backtrack(int k, int n){
        if(k == 0){
            return n;
        }
        int accum = 0;
        for(int i = 1; i <= n; i++){
            accum += backtrack(k - 1, i);
        }

        return accum;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(backtrack(k, n));
            
        }
    }
}
