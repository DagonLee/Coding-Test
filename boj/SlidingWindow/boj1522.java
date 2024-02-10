package boj.SlidingWindow;

import java.io.*;
import java.util.*;

public class boj1522 {
    /*
     * start 240210 18:56
     * 문제
     * a와 b로만 이루어진 문자열 이 주어진다.
     * a를 모두 연속으로 만들기 위해서 필요한 교환의 최소 횟수를 구하라
     * 문제 이해 못함 => 19:25
     * 질문 게시판 참조, 교환에 대한 정의가 모호
     * 
     * 다른 사람의 풀이 확인
     * 접근 방법을 정리하면 다음과 같다.
     * a를 모두 연속하게 만들려면 원래의 문자열에서 a개의 개수 만큼 연속해야된다.
     * a의 개수만큼을 윈도우 사이즈로 하여 이동시키면서 최소의 교환 횟수를 알아낸다.
     * 해결방법
     * 1. 원 문자열에서 a의 개수를 알아내기, 이 개수가 윈도우 사이즈가 된다.
     * 2. 0 ~ 마지막 인덱스를 시작으로 윈도우 사이즈 만큼의 문자열에서 b 의 개수가 교환 횟수가 된다.
     *    교환 횟수를 업데이트 한다.
     * 
     * String source:  문자열, 
     * int windowSize : a의 개수, 탐색 사이즈
     * int changeCnt : 교환 횟수의 최솟값, 1000으로 초기화
     * 
     * 20:33 해결
     * 
     * 
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String source = br.readLine();
        int windowSize = 0;
        int changeCnt = 1000;
        for(int i = 0; i < source.length(); i++){ //a 의 개수 알아내기
            if(source.charAt(i) =='a'){
                windowSize ++;
            }
        }
        for(int i = 0; i < source.length(); i++){
            int cnt = 0;
            for(int j = i; j < i + windowSize; j++){
                if(source.charAt(j % source.length()) == 'b'){
                    cnt ++;
                }
            }
            changeCnt = Math.min(changeCnt, cnt);
        }
        System.out.println(changeCnt);
    }
}
