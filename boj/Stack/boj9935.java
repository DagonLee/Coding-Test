package boj.Stack;

import java.io.*;
import java.util.*;
public class boj9935 {
    /*
     * start 240222 10:04
     * 문제
     * 문자열과 폭발 문자열이 주어진다.
     * 1. 만약 문자열안에 폭발 문자열이 존재한다면 문자열에서 폭발 문자열을 제거하고 남은 문자열을 합친다.
     * 2. 1번 과정을 폭발 문자열이 없을 때까지 진행한다.
     * 
     * 해결방법
     * String index of 로 찾은 후
     * 폭발 문자열의 크기 만큼 제거
     * => 시간초과 가능성 존재
     * 일단 구현 후 고민 => 메모리 초과, 다른 접근 방법 필요
     * 알고리즘 분류 확인 => 해결방법 생각못함
     * referecne 참조=> 아이디어 얻음
     * 1. 문자열을 문자형태로 스택에 집어넣으면서 폭발 문자열의 끝부터 비교
     * 2. 폭발 문자열의 전체와 같다면 제거
     * 3. 완벽히 같지 않다면 기존 입력 스택에 추가
     * 11:31 => 틀림 ,구현부에서 나는 오류라 예상
     * 나중에 다시 풀이
     * 13:34 => 초기 풀이를 그대로 두고 출력 부를 stringBuilder 를 사용 => 성공
     * 출력이 길어질때 시간초과, StringBUilder로 한번에 출력
     */
    public static void  main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] source = br.readLine().toCharArray();
        char[] explod = br.readLine().toCharArray();
        int len = explod.length;
        
        Stack<Character> stack = new Stack<>();
        for(char c : source){
            stack.add(c);
            if(stack.size() >= len){
                boolean same = true;
                for(int j = 0; j < len; j++){
                    if(stack.get(stack.size() - len + j) != explod[j]){
                        same = false;
                        break;
                    }
                }
                if(same){
                    for(int j = 0; j < len; j++){
                        stack.pop();
                    }
                }
            }
            
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }
        if(stack.isEmpty()){
            System.out.println("FRULA");
        }else{
            System.out.println(sb);
        }
    }
}
