package boj.Greedy;

import java.io.*;

public class boj2138 {
    /*
     * start: 240215 18:50
     * 문제
     * n개의 스위치가 주어진다.
     * i 번째 스위치를 누르면 i - 1, i, i + 1 전구의 상태가 바뀐다.
     * 단, 1번 스위치는 1,2번, n번 스위치는 n - 1, n번 스위치 상태만 바꾼다.
     * n개 전구의 현재 상태와 만들고자 하는 상태가 주어지고 우리가 만들고자 하는 상태가 주어졌을때 
     * 그 상태를 만들기 위한 최소 스위치 동작 횟수를 구하라
     * 
     * 해결방법
     * 만들고자하는 전구의 상태가 0이라면 0번 혹은 짝수번 누른 경우
     * 만들고자하는 전구의 상태가 1이라면 홀수번 누른 경우
     * 
     * 
     * 앞에서 부터 탐색하며 만약 자신의 상태가 0이고
     * 다음 전구 상태가 1이라면
     * 
     * 현재 상태와 다음
     * 19:07 문제 분류 힌트 얻음
     * 19:10 접근법 생각 못함, reference 참조할 예정
     * 
     * 240216 13:19
     * 다른 사람들의 풀이를 참조
     * i-1 번 전구의 상태를 좌우하는 것은 i 번 전구이다.
     * i-1 번 전구의 상태가 만들고자하는 전구의 i-1번 상태와 다른 경우에는 스위치를 켠다.
     * 0번 전구를 키는 경우와 안키는 경우 2가지를 구분하여 동작하여야한다.
     * 
     * 필요함수
     * 1. 전구를 키는 함수, i -1, i, i +1 동시 상태 변경
     * 2. 전구 상태 비교 함수, 원본과 비교하여 동일한지 확인
     * 3. 전구 상태 변환 함수, i-1 번의 전구 상태가 원본과 다른지 비교하여 상태를 변환하는 함수
     * 
     * 데이터
     * char[] source // 원본이 될 전구 상태 리스트
     * char[] target; // 목표 전구 상태 리스트 
     * 
     * 
     */
    static int n;
    public static void transfer(char[] source, int i){
        if(i - 1 >= 0){
            source[i - 1] = source[i - 1] == '0' ? '1':'0'; 
        }
        source[i] = source[i] == '0' ? '1' : '0';
        if(i + 1 < n){
            source[i + 1] = source[i + 1] == '0' ? '1' : '0';
        }
    }
    public static boolean check(char[] source, char[] target){
        for(int i = 0; i < n; i++){
            if(source[i] != target[i]){
                return false;
            }
        }
        return true;
    }
    public static int search(int cnt, char[] source, char[] target){
        int ans = cnt;
        for(int i = 1; i < n; i++){
            if(source[i - 1] != target[i - 1]){
                transfer(source, i);
                ans ++;
            }
        }
        if(check(source, target)){
            return ans;
        }
        return -1;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[] source = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();

        char[] copy1 = new char[n];
        char[] copy2 = new char[n];
        for(int i = 0; i < n; i++){
            copy1[i] = source[i];
            copy2[i] = source[i];
        }
        //0번 스위치를 안누른 경우
        int result1 = search(0, copy1, target);

        //0번 스위치 누른 경우
        transfer(copy2, 0);
        int result2 = search(1, copy2, target);

        if(result1 == -1){
            System.out.println(result2);
        }
        else if(result2 == -1){
            System.out.println(result1);
        }
        else if(result1 == -1 && result2 == -1){
            System.out.println(-1);
        }else{
            System.out.println(Math.min(result1, result2));
        }
    }
}
