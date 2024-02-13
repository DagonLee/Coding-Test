package boj.SlidingWindow;

import java.io.*;
import java.util.*;

public class boj20437 {
    /*
     * start 240213 11:48
     * 문제
     * 알파벳 W, 양의 정수 K가 주어진다.
     * 두가지를 구한다.
     * 1. 특정 문자를 정확히 K개 포함하는 가장 짧은 연속 문자열의 길이를 구한다.
     * 2. 특정 문자열 정확히 K개 포함하고 첫 번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열 길이를 구한다.
     * 
     * 핵심 요소
     * 특정 문자의 모든 등장 인덱스
     * 
     * 해결 방법
     * 1. W에서 알파벳 별 등장 인덱스를 각 동적 배열에 저장한다.
     * 2. 알파벳별 동적 배열의 크기가 K 이상인 경우에만 슬라이딩 윈도우 방식으로 탐색하여 가장 작은 길이, 큰 길이를 구한다.
     * 
     * 변수
     * int maxLen // 가장 작은 길이
     * int minLen // 가장 큰 길이 
     * 
     * 1차 구현
     * 12:23 => success
     * 탐색의 시작과 끝을 설정하는 부분에서 10분 정도 헤맸다.
     * 슬라이딩 윈도우류의 문제에 익숙해질 필요성이 있다.
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            int maxLen = 0;
            int minLen = 10001;
            char[] w = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());
            ArrayList<Integer>[] alphas = new ArrayList[30];
            for(int j = 0; j < alphas.length; j++){
                alphas[j] = new ArrayList<Integer>();
            }
            for(int j = 0; j < w.length; j++){
                alphas[w[j] - 'a'].add(j);
            }
            for(int j = 0; j < alphas.length; j++){
                if(alphas[j].size() >= k){
                    ArrayList<Integer> cur = alphas[j];
                    for(int d = 0; d <= cur.size() - k; d++){
                        int len = cur.get(d + k - 1) - cur.get(d) + 1;
                        // System.out.println(len);
                        maxLen = Math.max(maxLen, len);
                        minLen = Math.min(minLen, len);
                    }
                }
            }
            if(minLen != 10001){
                System.out.println(minLen + " " + maxLen);
            }
            else{
                System.out.println(-1);
            }
        }
    }
}
