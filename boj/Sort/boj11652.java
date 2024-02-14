package boj.Sort;

import java.io.*;
import java.util.*;

public class boj11652 {
    /*
     * start 240214 17:08
     * 문제 
     * n개의 수가 주어지고 가장 많이 나오는 수를 출력하시오
     * 만약 가장 많이 나오는 수가 여러개 라면 작은 것을 출력
     * 
     * 해결 방법
     * 1. 숫자 별 등장 횟수를 저장, 맵으로 저장
     * 2. 맵에 있는 숫자들을 순회 하여 최대 등장 횟수 수, 갯수를 찾는다.
     * 
     * 데이터
     * Map <Integer, Integer> map // key: 숫자, value: 등장 횟수
     * int num // 최대 등장 숫자
     * int cnt // 최대 등장 횟수
     * 구현 완료 => 17:17
     * numberFormatError => 입력이 2^62 까지여서 나는 오류 
     * Long 으로 수정하여 해결
     * 240214 17:21 => succes
     * 
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map <Long, Integer> map = new HashMap<>();
        Long num = 0L;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            long val = Long.parseLong(br.readLine());
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        for(long key : map.keySet()){
            int tmp = map.get(key);
            if(cnt < tmp){
                cnt = tmp;
                num = key;
            }
            else if(cnt == tmp && key < num){
                num = key;
            }
        }
        System.out.println(num);
    }
}
