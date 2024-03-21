package boj.Sort;

import java.io.*;
import java.util.*;

public class boj1766 {
    /*
     * 240321 09:46 
     * 문제
     * 1~n번까지 n개의 문제로 되어 있는 문제집이 있다.
     * 1번 문제가 가장 쉬운 문제이고 n번 문제가 가장 어려운 문제이다.
     * 세가지 조건에 따라 문제를 풀 순서를 정하였다.
     * 1. N개의 문제는 모두 풀어야 한다.
     * 2. 먼저 푸는 것이 좋은 문제가 있는 문제는, 먼저 푸는 것이 좋은 문제를 반드시 먼저 풀어야 한다.
     * 3.가능하면 쉬운 문제부터 풀어야 한다.
     * 문제 풀 순서를 결정해주는 프로그램을 작성하라
     * 
     * 해결방법
     * 위상정렬을 하되 사용하는 큐를 우선순위 큐로하여 오름차순으로 나오도록 저장
     * 09:55 성공
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] deg = new int[n + 1];
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            deg[b]++;
            adj[a].add(b);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= n; i++){
            if(deg[i] == 0){
                pq.add(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){
            int now = pq.poll();
            result.add(now);
            for(int nxt : adj[now]){
                deg[nxt]--;
                if(deg[nxt] == 0){
                    pq.add(nxt);
                }
            }
        }
        for(int num : result){
            System.out.print(num + " ");
        }
    }
}
