package boj.BackTracking;

import java.io.*;

public class boj12919 {
    /*
     * start 240212 14:43
     * 
     * 문제
     * 두 문자열 S, T가 주어진다.
     * S, T는 A와 B로만 구성되어 있다.
     * S를 T로 만들 수 있는지 알아내라.
     * 다음 두가지 연산만 가능
     * 1. 문자열 뒤에 A를 추가한다.
     * 2. 문자열의 뒤에 B를 추가하고 문자열을 뒤집는다.
     * 
     * 해결방법
     * 길이의 차이만큼 연산을 할수 있다.
     * 길이의 차이만큼 할 수 있는 모든 연산의 결과와 T를 비교하여 T와 같다면 1을 반환
     * 
     * 정리
     * 1. S로 할수 있는 모든 결과를 반환
     * 2. 모든 결과 들과 T를 비교 만약 같다면 ans를 true로 갱신
     * 
     * 15:04 => 시간 초과
     * 
     * 다른 방법 생각
     * T에서부터 S를 찾아가는 방식
     * 재귀를 사용, 
     * 현재 문자열이 S와 길이가 같다면 S와 비교
     * 문자열의 뒤에 A가 있다면 A를 제거하고 재귀함수 호출
     * 역 문자열의 뒤에 B가 있다면 B를 제거하고 재귀 함수 호출
     * 
     * 15:17 => success
     */
    static boolean ans = false;
    static int limit; // 연산 가능 횟수

    static String s;
    public static String reverse(String tmp){
        String copy = "";
        for(int i = tmp.length() - 1; i >= 0; i--){
            copy += tmp.charAt(i);
        }
        return copy;
    }
    public static void simulate(String tmp){
        if(tmp.length() == s.length()){
            if(tmp.equals(s)){
                // System.out.println(tmp + " " + s);
                ans = true;
            }
            return;
        }
        if(tmp.charAt(tmp.length() - 1) == 'A'){
            // System.out.println(tmp);
            simulate(tmp.substring(0, tmp.length() - 1));
        }
        String reversedTmp = reverse(tmp);
        if(reversedTmp.charAt(tmp.length() - 1) == 'B'){
            // System.out.println(reversedTmp);
            simulate(reversedTmp.substring(0, tmp.length() - 1));
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        String t = br.readLine();
        simulate(t);
        if(ans){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}
