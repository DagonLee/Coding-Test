package boj.Sort;

import java.io.*;
import java.util.*;

public class boj3758 {
    /*
     * start: 240201 14:16
     * k 개의 문제에 대해서 몇등인지 계산하는 문제
     * n : 팀 개수, t: 내 팀 id, 로그 개수: m 개
     * 기준
     * 1. 문제 별 팀 점수 기록
     * 2. 팀 별 마지막 제출 시간
     * 3. 팀 별 제출 횟수
     * 
     * 위 3가지 기준으로 정렬 후 내 팀 id의 인덱스 +1 을 반환
     * 1st try 14:52 => fail, 마지막 제출 갱신을 점수 갱신 조건문 안에 넣어서 에러 발생
     * 2nd try 14:54 => success
     */
    public static class Data implements Comparable<Data> {
        int id;
        int totScore;
        int lastSubmitTime;
        int totSubmitCount;
        public Data(int id, int totScore, int lastSubmitTime, int totSubmitCount){
            this.id = id;
            this.totScore = totScore;
            this.lastSubmitTime = lastSubmitTime;
            this.totSubmitCount = totSubmitCount;
        }
        @Override
        public int compareTo(Data o) {
            if(totScore == o.totScore){
                if(totSubmitCount == o.totSubmitCount){
                    return lastSubmitTime - o.lastSubmitTime;
                }
                return totSubmitCount - o.totSubmitCount;
            }
            return o.totScore - totScore;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());// 팀 개수
            int k = Integer.parseInt(st.nextToken());// 문제 개수
            int t = Integer.parseInt(st.nextToken());// 내팀 id
            int m = Integer.parseInt(st.nextToken());// 로그 개수
            int [][] score = new int[n + 1][k + 1]; // 팀별 점수 기록
            int [] submitCount = new int[n  +1 ]; // 팀별 제출 횟수
            int [] lastSubmit = new int[n + 1]; // 마지막 제출 시간
            for(int j = 0; j < m; j++){
                st = new StringTokenizer(br.readLine());
                int curId = Integer.parseInt(st.nextToken());
                int problemNum = Integer.parseInt(st.nextToken());
                int curScore = Integer.parseInt(st.nextToken());
                if(score[curId][problemNum] == 0 || score[curId][problemNum] < curScore){
                    score[curId][problemNum] = curScore;
                }
                lastSubmit[curId] = j;
                submitCount[curId] ++;
                
            }
            Data[] dataList = new Data[n];
            for(int j = 1; j <= n; j++){
                int scoreSum = 0;
                for(int p = 1; p <= k; p++){
                    if(score[j][p] != 0){
                        scoreSum += score[j][p];
                    }
                }
                dataList[j - 1] = new Data(j, scoreSum, lastSubmit[j], submitCount[j]);
                // System.out.println("id: " + j + "score" + scoreSum );
            }
            Arrays.sort(dataList);
            
            for(int j = 0; j < n; j++){
                if(dataList[j].id == t){
                    sb.append(j + 1);
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
