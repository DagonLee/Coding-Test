package boj.HashMap;

import java.io.*;
import java.util.*;

public class boj22233 {
    /*
     * start 240202 22:15
     * n개의 단어를 입력
     * m 번의 글을 쓴다.
     * 글을 쓸때마다 글안에 포함된 단어들을 키워드에서 제거
     * 
     * 1. 키워드를 맵에 저장, map<String, boolean>,초기에는 true로 기록, 키워드 개수도 저장
     * 2. 글을 입력 받고 ',' 단위로 split
     * 3. map을 조회하여 값이 false 라면 continue, true라면 키워드 개수 -1하고 값 false 로갱신
     * 4. 키워드 개수 반환
     * end 240202 22:32
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Map <String, Boolean> keyWordMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            String word = br.readLine();
            keyWordMap.put(word, true);
        }
        int ans = n;
        for(int i = 0; i < m; i++){
            String[] letter = br.readLine().split(",");
            for(int j = 0; j < letter.length; j++){
                if(keyWordMap.containsKey(letter[j]) && keyWordMap.get(letter[j])){
                    ans--;
                    keyWordMap.put(letter[j], false);
                }
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());
    }
}
