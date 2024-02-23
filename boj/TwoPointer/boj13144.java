package boj.TwoPointer;

import java.io.*;
import java.util.*;

public class boj13144 {
    /*
     * start 240222 20:57
     * 문제 분류를 확인해버림..
     * 문제
     * 1. 각 수를 맵에 넣어가면서 진행, 앞을 의미하는 start, 끝을 의미하는 end 지정
     * 2-1. 만약 맵에 이미 존재하는 경우, start 와 같다면 인덱스를 현재 시점으로 수정,start + 1 
     *      start와 같지 않다면 cnt + 1, start 이미 존재하는 경우 값 + 1 
     *      cnt + 1,end + 1
     * 2-2. 만약 맵에 이미 존재하지 않는 경우,맵에 데이터 추가, end += 1, 개수 += 1
     * 
     * 20240222 23:44 아직까지 구현 못함
     * https://dev-ljw1126.tistory.com/m/211 참고하여 내일 구현예정
     */
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] nums = new int[n  + 1];
        int [] cnt = new int[100001];
        for(int i = 1; i <= n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        long ans = 0L;
        while(start <= n){
            while(end <= n && cnt[nums[end]] == 0){
                cnt[nums[end]] ++;
                end ++;
            }
            ans += (end - start);
            cnt[nums[start]] --;
            start ++;
        }
        System.out.println(ans);
    }
}
