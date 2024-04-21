package boj.PriorityQueue;

import java.io.*;
import java.util.*;

public class boj15903 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            pq.add(Long.parseLong(st.nextToken()));
        }
        for(int i = 0; i < m; i++){
            long a = pq.poll();
            long b = pq.poll();
            pq.add(a + b);
            pq.add(a + b);
        }
        long ans = 0;
        for(Long score: pq){
            ans += score;
        }
        System.out.println(ans);
    }
}
