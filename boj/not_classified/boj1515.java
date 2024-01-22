package boj.not_classified;

import java.io.*;
import java.util.*;
public class boj1515 {
    // start 15:47 ~ 16:24
    // 16:39 reference : https://i-have-to.tistory.com/43
    // 초기 접근 방법
    // 0 ~ 9 출현 빈도를 식별하여 출현 빈도와 동일한 수를 반환 => 순서를 고려하지 않음
    // reference 방법
    // pos 로 주어진 문자열의 수를 특정
    // num에 pos 위치에 있는 수가 있다면 num + 1
    // 주어진 문자열을 모두 커버 한다면 num 반환
    // end : 17:00
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pos = 0;
        String str = br.readLine();
        int num = 1;

        while(pos < str.length()){
            char[] arr = Integer.toString(num).toCharArray();
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == str.charAt(pos)){
                    pos++;
                }
                if(pos == str.length()){
                    System.out.println(num);
                    return;
                }
            }
            num++;
        }
        
    }
}
