package boj.Stack;

import java.io.*;
import java.util.*;

public class boj1406 {
    /*
     * start 240204 09:39
     * 문제
     * 커서를 이동해서 문자열을 조작하는 문젠
     * 조작 명령어
     * L: 커서 왼쪽 이동
     * D: 커서 오른쪽 이동
     * B: 커서 왼쪽 문자 삭제
     * P $ : $ 문자 추가
     * 
     * 초기 문자열이 주어지고 명령어 수행 후 최종 문자열 출력
     * 
     * 해결방법
     * 커서의 위치를 저장
     * 동적 리스트에 문자들을 기록
     * 
     * 1st try 09:55 fail => time limit exceeded
     * 2nd try 10:10 modified to String, fail => time limit exceeded
     * 3nd try 10:11 modified to Linked List => time limit exceeded
     * 4th try 10:22 swith two dequeues => time limit exceeded
     * 5th try 10:24 with StringBuilder => successs
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();        
        String str = br.readLine();
        ArrayDeque<Character> front = new ArrayDeque<>();
        ArrayDeque<Character> back = new ArrayDeque<>();

        for(int i = 0; i < str.length(); i++){
            front.addLast(str.charAt(i));
        }
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            if(c == 'L'){
                if(!front.isEmpty()){
                    back.addFirst(front.pollLast());
                }
            }else if(c == 'D'){
                if(!back.isEmpty()){
                    front.addLast(back.pollFirst());
                }
            }else if(c == 'B'){
                if(!front.isEmpty()){
                    front.pollLast();
                }
            }else if(c == 'P'){
                char insertChar = st.nextToken().charAt(0);
                front.addLast(insertChar);
            }
        }
        for(char c : front){
            sb.append(c);
        }
        for(char c : back){
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}