package boj.Dijkstra;

import java.io.*;
import java.util.*;

public class boj1238 {
    /*
    start 240225 10:30
     * n개의 마을이 주어지고 m 개의 간선과 가중치가 주어진다.
     * 각 마을에서 x마을을 왕복하는데 드는데 가장 오래걸리는 시간을 출력하라.
     * 
     * 해결방법
     * 1. 각 마을에서 다른 마을로 가는 최단 거리를 구해놓는다.
     * 2. 각 마을 과 x의 왕복 거리를 비교하여 최댓 값을 갱신
     * 
     * 다익스트라를 활용하여 최단 거리 맵을 구해놓고 비교
     */
    public static class Node implements Comparable<Node>{
        int num;
        int value;
        Node(int num, int value){
            this.num = num;
            this.value = value;
        }
        public int compareTo(Node o){
            return value - o.value;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m, x;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        ArrayList<Node>[] adjList = new ArrayList[n  + 1];
        for(int i = 1; i <= n; i++){
            adjList[i] = new ArrayList<Node>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[s].add(new Node(e, v));
        }
        int[] ans = new int[n + 1];
        for(int i = 1; i<= n; i++){
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(i, 0));
            int[] dist = new int[n + 1];
            for(int j = 1; j <= n; j++){
                dist[j] = Integer.MAX_VALUE;
            }
            dist[i] = 0;
            while(!pq.isEmpty()){
                Node now = pq.poll();
                for(Node next : adjList[now.num]){
                    if(dist[next.num] > (dist[now.num] + next.value)){
                        dist[next.num] = dist[now.num] + next.value;
                        pq.add(new Node(next.num, dist[next.num]));
                    }
                }
            }
            if(i == x){
                for(int j = 1; j <= n; j++){
                    if(j == i){
                        continue;
                    }
                    ans[j] += dist[j];
                }
            }
            else{
                ans[i] += dist[x];
            }
            
        }
        int max = 0;
        for(int j = 1; j<= n; j++){
            max = Math.max(max, ans[j]);
        }
        System.out.println(max);
    }
}
