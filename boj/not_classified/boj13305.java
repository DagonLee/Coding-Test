package boj.not_classified;

import java.io.*;
import java.util.*;
import java.math.*;
public class boj13305 {
    public static void main(String[] args) throws Exception{
        // start: 240121 16:51
        // stop : 17:02
        // re-start : 17:15
        // 1st try : 17:47 => score:58
        // 2nd try :  score :58 
        // 3 ~ 7th try : tried with BigInteger , score:17
        // 8th try : 18:20, changed to Long => success: 100
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 앞에서 부터 비교
        // 현재 주유 비용과 과거의 최소 주유 비용을 비교
        // 현재 까지의 이동거리, 최소 주유 비용 저장, 현재의 총 주유 비용
        // 
        //  2 - 3 - 1
        //5 - 2 - 4 - 1
        int n = Integer.parseInt(br.readLine());
        long[] dist = new long[n - 1];
        long[] cost = new long[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n - 1; i++){
            dist[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            cost[i] = Long.parseLong(st.nextToken());
        }

        long min_cost = cost[0];
        long ans = dist[0] * cost[0];
        for(int i = 1; i < n  - 1; i++){
            if(min_cost > cost[i]){
                min_cost = cost[i];
            }
            ans += (min_cost * dist[i]);
        }
        System.out.println(ans);
    }
}
