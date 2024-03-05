package boj.Dijkstra;

import java.io.*;
import java.util.*;
public class boj1504 {
    /*
     * 240305 10:02
     * 문제 1번 정점에서 n번 정점으로 최단거리로 이동하려고 할때
     * 주어진 두 정점은 반드시 통과하면서 최단거리가 되는 길이를 구하라
     * 만약 없다면 -1 출력
     * 
     * 해결방법
     * 정점 u, v를 반드시 지나야할때
     * 모든 경우의 수를 식별
     * 1 -> u -> v -> n
     * 1 -> v -> u -> n
     * 2가지 경우 중 최솟 값을 출력
     * 
     * 다익스트라를 이용하여 각 간선에서의 최솟값을 식별
     * 1. 1번정점을 기준으로 한 다익스트라 생성
     * 2. u 정점을 기준으로 한 다익스트라 생성
     * 3. v 정점을 기준으로 한 다익스트라 생성
     * 4. n 정점을 기준으로 한 다익스트라 생성
     * 
     * 11:03 해결 완료
     * 헤맸던 부분
     * 하나의 방문 루트 ex) 1->u 가 방문하지 못하는 경우 현재 구현에서는 int 최댓값으로 두었다.
     * 한 방문 루트에서 한 파트만 방문하지 못해도 int 오버플로우가 난다.
     * 이부분을 예외 처리해야하거나 정수형 최대형이 아닌 다른 값으로 설정해야한다.
     * 이 구현에서는 예외 처리함
     * 1 -> n 사이에 u와 v 등장 시점을 결정해야한다.
     * 이부분에서 n 방문 이후 u, v 지점을 탐색하게 하여서 오류 발생
     * 
     * 
     */
    static class Vertex implements Comparable<Vertex>{
        int dest;
        int val;
        Vertex(int dest, int val){
            this.dest = dest;
            this.val = val;
        }
        public int compareTo(Vertex o){
            return this.val - o.val;
        }
    }
    static int n;
    static ArrayList<Vertex>[] adj;
    static int[] dijkstra(int start){

        int[] dist = new int[n];
        for(int i = 0; i < n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(new Vertex(start, 0));
        while(!pq.isEmpty()){
            Vertex now = pq.poll();
            for(Vertex next : adj[now.dest]){
                if(dist[next.dest] > dist[now.dest] + next.val){
                    dist[next.dest] = (dist[now.dest] + next.val);
                    pq.add(next);
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int e;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<Vertex>();
        }
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Vertex(b, c));
            adj[b].add(new Vertex(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken()) - 1;
        int v = Integer.parseInt(st.nextToken()) - 1;
        int[] dist = dijkstra(0);
        int oTou = dist[u];
        int oTov = dist[v];
        
        dist = dijkstra(u);
        int uTo0 = dist[0];
        int uTov = dist[v];
        int uTon = dist[n - 1];
        
        dist = dijkstra(v);
        int vTou = dist[u];
        int vTon = dist[n - 1];
        
        int firstCase;
        int secondCase;
        
        if(oTou == Integer.MAX_VALUE || uTov == Integer.MAX_VALUE || vTon == Integer.MAX_VALUE){
            firstCase = Integer.MAX_VALUE;
        }
        else{
            firstCase = uTo0 + uTov + vTon;
        }
        if(oTov == Integer.MAX_VALUE || vTou == Integer.MAX_VALUE || uTon == Integer.MAX_VALUE){
            secondCase = Integer.MAX_VALUE;
        }
        else{
            secondCase = oTov + vTou + uTon;
        }
       
        int ans = Math.min(firstCase, secondCase);
      
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }
    }
}
