package boj.Dijkstra;

import java.io.*;
import java.util.*;

public class boj20183 {
    /*
     * 240308 11:22
     * 문제
     * 시작점과 도착점이 주어지고 최소 비용 경로를 찾고 그 경로 중 최대 비용을 내는 부분의 비용을 계산
     * 
     * 
     * 해결방법
     * 1. 다익스트라를 사용 하되 탐색 허용 조건을 다르게 한다. 
     * 2. 허용 조건 : 거리 배열의 값, 경로 중 최대 비용
     * 
     * 12:14
     * => 부분 점수
     * 
     * 12:51 현재 풀이 못함
     * 3개의 테스트 케이스에서 틀림
     * => 풀이 참고 예정
     * 
     * 참고 풀이 요약
     * 1. 다익스트라로 최단거리를 탐색하되 최대 비용의 제한을 두어 탐색
     * 2. 최대 비용 제한이 최소가 되도록 이분 탐색을 사용
     * 
     */
    static class Vertex implements Comparable<Vertex>{
        int name;
        long dist;
        Vertex(int name, long dist){
            this.name = name;
            this.dist = dist;
        }
        public int compareTo(Vertex o){
            return Long.compare(dist, o.dist);
        }
    }
    static ArrayList<Vertex>[] adj;
    static long[] dist;
    static long c;
    static boolean Dijkstra(int start, int target, long limit){
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Vertex(start, 0));
        while(!pq.isEmpty()){
            Vertex now = pq.poll();
            if(dist[now.name] != now.dist){
                continue;
            }
            for(Vertex nxt : adj[now.name]){
                if(nxt.dist > limit){
                    continue;
                }
                if(dist[nxt.name] <= (dist[now.name] + nxt.dist) ){
                    continue;
                }
                dist[nxt.name] = dist[now.name] + nxt.dist;
                pq.add(new Vertex(nxt.name, dist[nxt.name]));
            }
        }
        if(dist[target] > c ){
            return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m, a, b;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Long.parseLong(st.nextToken());
        adj = new ArrayList[n + 1];
        dist = new long[n + 1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>();
        }
        long left = 0L;
        long right = 0;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[s].add(new Vertex(e, v));
            adj[e].add(new Vertex(s, v));
            right = Math.max(right , v);
        }
        
        while(left < right){
            long mid = (left + right) / 2;
            if(Dijkstra(a, b, mid)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        if(Dijkstra(a, b, left)){
            System.out.println(left);
        }
        else{
            System.out.println(-1);
        }
    }
}
