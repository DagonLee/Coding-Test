package boj.Implementation;

import java.io.*;
import java.util.*;

public class boj20529 {
    /*
     * 240309 09:57
     * 문제
     * mbti가 주어지고 유사도가 가장 높도록 3가지를 선택하고
     * 각각의 mbti들의 다른 부분들의 개수를 반환하라
     * 
     * 해결방법
     * 모든 mbti 정렬후 슬라이딩 윈도우로 최소한의 다른 점들이 되는 개수를 찾는다. 
     * => 틀림
     * 모든 경우의 수 를 확인하는 방식으로 변경
     * => 틀림
     * 다른 풀이를 확인
     * 풀이 요약
     * 주어진 입력의 종류가 16종류라른 점을 이용하여 비둘기 집 원리를 적용
     * 33개 이상의 입력이 주어진다면 mbti 중복 최댓값이 3이상이라는 점을 이용하여 0 반환하도록 수정
     */
    public static int diff(String a, String b){
        int cnt = 0;
        for(int i = 0; i < 4; i++){
            if(a.charAt(i) != b.charAt(i)){
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++){
            int max = Integer.MAX_VALUE;
            int n = Integer.parseInt(br.readLine());
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<String> mbtiList = new ArrayList<>();
            for(int i = 0; i < n; i++){
                mbtiList.add(st.nextToken());
            }
            if(n >= 33){
                sb.append("0\n");
                continue;
            }
            for(int i = 0; i < n - 2; i++){
                for(int j = i + 1; j < n - 1; j++){
                    for(int k = j + 1; k < n; k++){
                        String first = mbtiList.get(i);
                        String second = mbtiList.get(j);
                        String third = mbtiList.get(k);
                        int firstDif = diff(first, second);
                        int secondDif = diff(second, third);
                        int thirdDif = diff(third, first);
                        max = Math.min(max, (firstDif + secondDif + thirdDif));
                    }
                }
            }
            sb.append(max + "\n");
        }
        System.out.println(sb.toString());
    }
}
