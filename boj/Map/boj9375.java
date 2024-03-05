package boj.Map;

import java.io.*;
import java.util.*;
public class boj9375 {
    /*
     * 240305 08:55
     * 문제
     * 의상과 의상의 종류가 주어질때 조합의 경우의 수 개를 구하라
     * 
     * 해결방법
     * 1. 종류별 개수를 알아낸다.
     * 2. 종류별 개수 + 1을 하여 총개수에 곱해준다.=>안고르는 경우의 수를 추가해서 구하기 위함
     * 3. 모두 안고르는 경우의 수 1가지를 빼주고 결과를 출력
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();        
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> count = new HashMap<>();
            int ans = 1;
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String costume = st.nextToken();
                String type = st.nextToken();
                count.put(type, count.getOrDefault(type, 0) + 1);
            }
            for(int cur : count.values()){
                ans *= (cur + 1);
            }
            ans -= 1;
            sb.append(ans + "\n");
        }
        System.out.println(sb.toString());
    }
}
