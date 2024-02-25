package boj.Implementation;

import java.io.*;
import java.util.*;
public class boj14658 {
    /*
     * 240226 06:52
     * 별똥별이 가로 n, 세로 m 길이의 구역에 떨어질때, l * l 크기의 트램펄린으로 막을 수 있다.
     * 최대한 많은 별똥별을 막을때 막을 수 없느 ㄴ별똥별의 개수를 구하라
     * 
     * 해결방법
     * ㅣ의 크기에 따라 이동시켜가면서 최대로 많은 별똥별을 막을 수 있는 위치를 구하고 
     * 그때 총 별똥별의 개수에서 막는 별똥별의 개수를 빼고 저장
     * 07:38 => 시간초과
     * 질문 게시판 참조
     * 별똥별 리스트에서 두 지점을 기준으로 안에 들어올 수 있는지를 확인하는 방법
     * 3중 for문을 이용
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m, l, k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ArrayList<int[]> stars = new ArrayList<>();
        for(int i = 0; i < k; i ++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new int[]{x, y});
        }
        int len = stars.size();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                int[] s = stars.get(i);
                int[] e = stars.get(j);
                int cnt = 0;
                for(int cur = 0; cur < len; cur++){
                    int[] now = stars.get(cur);
                    if(s[0] <= now[0] && now[0] <= s[0] + l && e[1] <= now[1] && now[1] <= e[1] + l){
                        cnt++;
                    }
                }
                min = Math.min(stars.size() - cnt, min);
            }
        }
        System.out.println(min);
    }
}
