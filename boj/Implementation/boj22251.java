package boj.Implementation;

import java.io.*;
import java.util.*;

public class boj22251 {
    /*
     * start 240218 15:26
     * 문제
     * 엘리베이터 LED가 있다.
     * 층수 : n
     * 디스플레이 개수 : k
     * led 상태 변경 횟수 : p
     * 실제 층 : x
     * 
     * 해결방법
     * 1. 초기 디스플레이를 세팅
     * 2. 모든 디스플레이 케이스와 비교한다.
     * 2-1. 한 케이스를 진행 중 led 상태 변경 횟수 보다 차이가 많다면 종료
     * 2-2. 차이가 적거나 같다면 경우의 수 + 1
     * 
     * 
     */
    public static String fillZero(String data, int k){
        String zeros = "";
        for(int i = 0; i < k - data.length(); i++){
            zeros += "0";
        }
        String result = zeros + data;
        return result;
    }
    public static void main(String[] args) throws Exception{
        Map<Character, Integer> lights = new HashMap<>();
        lights.put('0',Integer.parseInt("1111110", 2));
        lights.put('1',Integer.parseInt("0110000", 2));
        lights.put('2',Integer.parseInt("1101101", 2));
        lights.put('3',Integer.parseInt("1111001", 2));
        lights.put('4',Integer.parseInt("0110011", 2));
        lights.put('5',Integer.parseInt("1011011", 2));
        lights.put('6',Integer.parseInt("1011111", 2));
        lights.put('7',Integer.parseInt("1110000", 2));
        lights.put('8',Integer.parseInt("1111111", 2));
        lights.put('9',Integer.parseInt("1111011", 2));


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k, p, x;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        
        char[] source= fillZero(x+"", k).toCharArray();
        int limit = 1;
        for(int i = 0; i < k; i++){
            limit *= 10;
        }
        int ans = 0;
        for(int i = 1; i < limit; i++){
            if(i == x){
                continue;
            }
            char[] val = fillZero(i + "", k).toCharArray();
            int cnt = 0;
            for(int j = 0; j < source.length; j++){
                int s = lights.get(source[j]);
                int t = lights.get(val[j]);
                if(s == t){
                    continue;
                }
                int dif = s ^ t;
                char[] data = Integer.toBinaryString(dif).toCharArray();
                for(char c : data){
                    if(c == '1'){
                        cnt++;
                    }
                }
                if(cnt > p){
                    break;
                }
            }
            if(cnt <= p && i <= n){
                // System.out.println(i);
                ans ++;
            }
        }
        System.out.println(ans);

    }
}
