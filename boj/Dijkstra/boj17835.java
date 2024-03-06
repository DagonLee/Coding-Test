package boj.Dijkstra;

import java.io.*;
import java.util.*;

public class boj17835 {
    /*
     * start 240306 10:06
     * 문제
     * n개의 도시가 주어지고 그중 k개를 면접장으로 지정
     * 도시끼리는 단방향 도로로 연결
     * 모든 면접자는 본인 도시에서 가장 가까운 면접장으로 이동
     * 면접장에서 가장 먼 도시를 구하고 그 거리를 구하라
     * 단, 거리가 같은 도시가 여러개라면 도시 번호가 가장 작은 번호를 출력
     * 
     * 해결방법
     * 1. 면접장이 아닌 도시들에서 가장 가까운 면접장의 거리를 알아내고 최단 거리와 번호를 갱신한다.
     * 
     * 다익스트라를 이용하여 각 도시별 면접장 최단 거리를 구한다.
     * 변수
     * int minName // 최단 거리 도시 번호
     * int minDist // 최단 거리
     * 
     * 10:21 stop
     * 10:29 start
     * 11:29 reference 참조하여 해결 https://minbear.tistory.com/m/174
     */
    static class Vertex implements Comparable<Vertex>{
        int name;
        long dist;
        Vertex(int name, long dist){
            this.name = name;
            this.dist = dist;
        }
        public int compareTo(Vertex o){
            return Long.compare(this.dist, o.dist);
        }
    }
    static int n;
    static boolean[] isInterview;
    static ArrayList<Vertex>[] adj;
    static long maxDist = 0;
    static int maxName = 100001;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m, k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n + 1];
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        isInterview = new boolean[n + 1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<Vertex>();
        }
        long[] dist = new long[n + 1];
        for(int i = 1; i <= n; i++){
            dist[i] = Long.MAX_VALUE;
        }
        for(int i = 0; i< m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[v].add(new Vertex(u, c));
            
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            int cur = Integer.parseInt(st.nextToken());
            dist[cur] = 0;
            pq.add(new Vertex(cur, 0));
        }
        
        
        while(!pq.isEmpty()){
            Vertex now = pq.poll();
            if(dist[now.name] != now.dist ){
                continue;
            }
            for(Vertex next : adj[now.name]){
                if(dist[next.name] > (dist[now.name] + next.dist)){
                    dist[next.name] = (dist[now.name] + next.dist);
                    pq.add(new Vertex(next.name, dist[next.name]));
                }
            }
        }
        for(int i = 1; i <= n; i++){
            if(maxDist < dist[i]){
                maxDist = dist[i];
                maxName = i;
            }
            else if(maxDist == dist[i]){
                if(maxName > i){
                    maxName = i;
                }
            }
        }
        System.out.println(maxName);
        System.out.println(maxDist);
    }
}