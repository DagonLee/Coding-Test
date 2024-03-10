package boj.Dijkstra;

import java.io.*;
import java.util.*;
public class boj1167 {
    /*
     * 240310 15:54
     * 문제
     * 트리의 지름을 구하라
     * 
     * 해결방법
     * 1. 1번에서 가장 먼 지점을 구한다.
     * 2. 1번 지점과 가장 먼 거리를 출력한다.
     */
    static class Vertex implements Comparable<Vertex>{
        int name;
        int dist;
        Vertex(int name, int dist){
            this.name = name;
            this.dist = dist;
        }
        public int compareTo(Vertex o){
            return dist - o.dist;
        }
    }
    static int v;
    static ArrayList<Vertex>[] adj;
    static int[] Dijkstra(int start){
        int[] dist = new int[v + 1];
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        for(int i = 1; i <= v; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        pq.add(new Vertex(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Vertex now = pq.poll();
            if(dist[now.name] != now.dist){
                continue;
            }
            for(Vertex nxt : adj[now.name]){
                if(dist[nxt.name] > dist[now.name] + nxt.dist){
                    dist[nxt.name] = dist[now.name] + nxt.dist;
                    pq.add(new Vertex(nxt.name, dist[nxt.name]));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        adj = new ArrayList[v + 1];
        for(int i = 1; i <= v; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i <= v; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int e = Integer.parseInt(st.nextToken());
                if(e == -1){
                    break;
                }
                else{
                    int val = Integer.parseInt(st.nextToken());
                    adj[s].add(new Vertex(e, val)); 
                }
            }
        }
        int[] dist = Dijkstra(1);
        int maxDist = -1;
        int maxName = -1;
        for(int i = 1; i<= v; i++){
            if(maxDist < dist[i]){
                maxDist = dist[i];
                maxName = i;
            }
        }

        maxDist = -1;
        dist = Dijkstra(maxName);
        for(int i = 1;i <= v; i++){
            if(maxDist < dist[i]){
                maxDist = dist[i];
                maxName = i ;
            }
        }
        System.out.println(maxDist);
    }
}
