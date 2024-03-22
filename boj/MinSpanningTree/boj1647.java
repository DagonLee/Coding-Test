package boj.MinSpanningTree;

import java.io.*;
import java.util.*;

public class boj1647 {
    /*
     * 240322 13:41
     * 문제
     * n개의 집과 m개의 연결이 주어질때 두개의 마을로 구분하고, 각 마을의 모든 집을 연결하는 경로의 최소 연결 유지비용을 구하라
     * 
     * 해결방법
     * 크루스칼 알고리즘 사용하여 MST 구현하여 비용의 쵯값을 출력
     * 14:06 문제를 제대로 이해하지 못한 것을 인지
     * 최소 연결 유지 비용을 구하는 것은 맞지만 마을을 두개로 분리해야됨
     * => MST 로 최소 연결 유지 비용을 구하되 간선의 개수를 n - 1개가 아닌 n - 2개가 될때까지만 구현하여
     * 마을이 두개가 되도록 한다.
     */
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int val;
        Edge(int start, int end, int val){
            this.start = start;
            this.end = end;
            this.val = val;
        }
        public int compareTo(Edge o){
            if(val == o.val){
                return start - o.start;
            }
            return val - o.val;
        }
    }
    static int[] parent;
    static int[] rank;
    static int find(int num){
        if(parent[num] == num){
            return num;
        }
        return parent[num] = find(parent[num]);
    }
    static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB){
            return false;
        }
        if(rank[rootA] < rank[rootB]){
            parent[rootA] = rootB;
        }
        else{
            parent[rootB] = rootA;
            if(rank[rootA] == rank[rootB]){
                rank[rootA]++;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        rank = new int[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a, b, v));
        }
        int cnt = 1;
        int ans = 0;
        while(cnt < n - 1){
            Edge now = pq.poll();
            int start = now.start;
            int end = now.end;
            int val = now.val;
            if(union(start, end)){
                ans += val;
                cnt++;
            }
        }
        System.out.println(ans);
    }
    
}
