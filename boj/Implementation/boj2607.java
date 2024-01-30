package boj.not_classified;

import java.io.*;
import java.util.*;

public class boj2607 {
    /**
    start 14:24 ~ 16:12 포기
    Map <char, Int> key: alpha, value : count
    한 단어를 더,빼,교체 해서 같은 구성이 되려면 빈도 수의 차이가 1 이거나
    원 단어를 기준으로 비교할 단어를 비교
    비슷한 단어가 되는 경우의 수
    1. 더해야 하는 경우
     1-1) 두 단어의 단어 맵의 키 리스트가 같으나 빈도수의 차이가 1 나는 경우
     1-2) 원 단어가 가진 단어 맵의 키 리스트 중 한가지가 비교 단어 맵 키 리스트에 없고 원 단어 맵의 빈도수가 1인 경우
    2. 빼야하는 경우
     2-1) 두 단어의 단어 맵의 키 리스트가 같으나 빈도수의 차이가 1 나는 경우
     2-2) 비교 단어가 가진 단어 맵의 키 리스트 중 한가지가 원 단어 맵 키 리스트에 없고 원 단어 맵의 빈도수가 1인 경우
    3. 교체 해야하는 경우
     3-1) 비교 단어 맵 리스트 의 빈도가 1 작은 것이 하나 1 큰것이 하나 있을때
     3-2) 비교 단어 맵의 키 리스트 길이가 더 큰 경우, 겹치지 않는 글자의 빈도수가 1이고, 겹치는 단어들 중 빈도 수가 1 작은 경우

    14:43 분기 수정
    1. 원단어 맵 길이 == 비교단어 맵 길이
        맵 키 리스트가 같고, 빈도 수 차이가 0 또는 1이어야한다.
    2. 원단어 맵 길이 - 비교 단어 맵 길이 == 1 (원단어 맵 길이가 1 큰 경우)
        원단어 에만 있는 단어의 개수가 1, 다른 단어들의 종류는 모두 같아야하고, 빈도수는 비교단어 맵이 한개 더 많거나, 같아야한다.
    3. 원단어 맵 길이 - 비교 단어 맵 길이 == -1
        비교단어 에만 있는 단어의 개수가 1, 다른 단어들의 종류는 모두 같아야하고, 빈도수는 원단어 맵이 한개 더 많거나, 같아야한다.
     
    16:45 => https://gyong0117.tistory.com/89 참고
        * 
     */
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String source = br.readLine();
        char[] sourceList = source.toCharArray();
        int ans = 0;
        int []s_alpha = new int[26];
        for(char c: sourceList){
            s_alpha[c - 'A'] ++;
        }
        for(int i = 1; i < n; i++){
            String str = br.readLine();
            char[] tmp = str.toCharArray();
            int[] copy = new int[26];
            for(int j = 0; j < 26; j++){
                copy[j] = s_alpha[j];
            }
            int same = 0;
            for(int j = 0; j < tmp.length; j++){
                if(copy[tmp[j] - 'A'] > 0){
                    copy[tmp[j] - 'A']--;
                    same++;
                }
            }
            if(source.length() == tmp.length){
                if(same == source.length() || same == source.length() - 1){
                    ans++;
                }
            }
            else if(source.length() - 1 == tmp.length && same == source.length() - 1){
                ans++;
            }
            else if(source.length() + 1 == tmp.length && same == source.length()){
                ans++;
            }
            else{
                continue;
            }
            
        }
        System.out.println(ans);
    }
}
