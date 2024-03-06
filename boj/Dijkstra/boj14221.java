package boj.Dijkstra;

import java.io.*;
import java.util.*;

public class boj14221 {
    static class Vertex implements Comparable<Vertex>{
        int name;
        int dist;
        Vertex(int name, int dist){
            this.name = name;
            this.dist = dist;
        }
        public int compareTo(Vertex o){
            return this.dist - o.dist;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<Vertex>[] adj = new ArrayList[n + 1];
        int[] dist = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i = 1; i<= n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Vertex(b, c));
            adj[b].add(new Vertex(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int p, q;
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> Home = new ArrayList<>();
        for(int i = 0; i < p; i++){
            Home.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        for(int i = 0; i < q; i++){
            int cur = Integer.parseInt(st.nextToken());
            dist[cur] = 0;
            pq.add(new Vertex(cur, 0));
        }
        
        while(!pq.isEmpty()){
            Vertex now = pq.poll();
            if(dist[now.name] != now.dist){
                continue;
            }
            for(Vertex next : adj[now.name]){
                if(dist[next.name] > dist[now.name] + next.dist){
                    dist[next.name] = (dist[now.name] + next.dist);
                    pq.add(new Vertex(next.name, dist[next.name]));
                }
            }
        }
        int minDist = Integer.MAX_VALUE;
        int minName = 50001;

        for(int i : Home){
            if(dist[i] == Integer.MAX_VALUE){
                continue;
            }
            if(minDist > dist[i]){
                minDist = dist[i];
                minName = i;
            }
            else if(minDist == dist[i]){
                if(minName > i){
                    minName = i;
                }
            }
        }
        System.out.println(minName);
    }
}
