package boj.Graph;

import java.io.*;
import java.util.*;

public class boj1967 {
    /*
     * 240305 09:55
     * 문제
     * 트리의 지름을 파악하는 문제
     * 
     * 해결방법
     * 1. 한정점을 잡고 그 정점에서 가장 먼 거리에 있는 정점을 구한다.
     * 2. 1번 정점에서 구한 정점에서 가장 먼 정점과의 거리를 구하여 반환한다.
     */
    static class Vertex{
        int dest;
        int val;
        Vertex(int dest, int val){
            this.dest = dest;
            this.val = val;
        }
    }
    static int farIdx = -1;
    static int farDist = -1;
    static ArrayList<Vertex>[] adj;
    static boolean[] visited;
    static void dfs(int now, int dist){
        if(visited[now]){
            return;
        }
        visited[now] = true;
        if(farDist < dist){
            farDist = dist;
            farIdx = now;
        }
        for(Vertex next : adj[now]){
            dfs(next.dest, dist + next.val);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<Vertex>();
        }
        for(int j = 1; j < n; j++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()) - 1;
            int child = Integer.parseInt(st.nextToken()) - 1;
            int val = Integer.parseInt(st.nextToken());
            adj[parent].add(new Vertex(child, val));
            adj[child].add(new Vertex(parent, val));
        }
        //0 번 노드에서 가장 먼 노드를 찾는다.
        farIdx = -1;
        farDist = -1;
        visited = new boolean[n];
        dfs(0, 0);
        visited = new boolean[n];
        int standIdx = farIdx;
        farIdx = -1;
        farDist = -1;
        dfs(standIdx, 0);

        System.out.println(farDist);
    }
}
