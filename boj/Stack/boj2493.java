package boj.Stack;

import java.io.*;
import java.util.*;

public class boj2493 {
    /*
     * 240213 12:42
     * 문제
     * n개의 높이가 서로 다른 탑이 왼쪽 부터 오른쪽으로 차례로 있다.
     * 각 탑의 꼭대기에는 레이저 송신기가 있다, 각 탑에서는 레이저 신호를 왼쪽으로 발사한다.
     * 각 탑의 기둥에는 레이저 수신기가 있다.
     * 하나의 탑에서 발사된 레이저 신호는 가장 먼저 만나는 하나의 탑에서만 수신한다.
     * 각 탑에서 발사한 레이저 신호는 어디서 수신하는지 출력하라
     * 만약 수신하는 탑이 없다면 0을 출력한다.
     * 
     * 입력
     * int n //탑의 수, 1 ~ 500,000
     * 
     * 핵심 사항
     * 각 탑에서 왼쪽에 존재하는 탑들 중에서 자신 보다 크고 인덱스가 가장 큰 값을 찾아야한다.
     * 
     * 해결방법
     * 입력이 50만이므로 이중 반복문으로는 시간초과
     * 이분 탐색으로 판단 12:52, 이분 탐색이 되려면 정렬이 되어있어햐는데 되어있지 않음 다시 고민
     * 
     * 문제 분류 힌트를 얻음 13:01
     * 해결방법을 떠올리지 못하여 풀이 검색
     * 스택을 이용한 방법 참조 (https://velog.io/@hyunjong96/BOJ-2493-%ED%83%91)
     * 정리
     * 스택을 이용한다.
     * 탑의 길이를 저장하는 배열과 결과를 저장할 배열을 선언
     * 탑 길이 배열을 순회하며 스택이 비어있다면 stack에 넣는다.
     * 스택이 비어있지 않는 동안 현재 탑 길이 보다 작은 이전의 탑 길이들을 스택에서 제거
     * 만약 현재 탑 길이보다 큰 탑 길이가 있다면 결과 배열에 해당 탑의 길이를 저장하고 루프를 나온다.
     * 항상 현재 탑길이를 스택에 추가
     * 
     * 13:25 => success
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] buildings = new int[n];
        int[] results = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            buildings[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            int curHeight = buildings[i];
            if(stack.isEmpty()){
                stack.add(i);
            }
            else{
                while(!stack.isEmpty()){
                    int lastIdx = stack.getLast();
                    if(buildings[lastIdx] < curHeight){
                        stack.pollLast();
                    }
                    else{
                        results[i] = lastIdx + 1;
                        break;
                    }
                }
                stack.offerLast(i);
            }
        }
        for(int i = 0; i < n; i++){
            System.out.print(results[i] +  " ");
        }
    }
}
