package boj.Dijkstra;

import java.io.*;
import java.util.*;

public class boj1916 {
    static class Node implements Comparable<Node>{
        int dest;
        int val;
        Node(int dest, int val){
            this.dest = dest;
            this.val = val;
        }
        public int compareTo(Node o){
            return val - o.val;
        }
    }
    static int n;
    static ArrayList<Node>[] adj;
    static int[] Dijkstra(int start, int end){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] cost = new int[n + 1];
        for(int i = 1; i <= n; i++){
            cost[i] = Integer.MAX_VALUE;
        }
        pq.add(new Node(start, 0));
        cost[start] = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.val > cost[now.dest]){
                continue;
            }
            for(Node nxt : adj[now.dest]){
                if(nxt.val + cost[now.dest] < cost[nxt.dest]){
                    cost[nxt.dest] = (nxt.val + cost[now.dest]);
                    pq.add(new Node(nxt.dest, nxt.val));
                }
            }
        }
        return cost;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            adj[start].add(new Node(end, val));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int [] cost = Dijkstra(start, end);
        System.out.println(cost[end]);
    }
}
