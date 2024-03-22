package boj.MinSpanningTree;

import java.io.*;
import java.util.*;

public class boj16398 {
    /*
     * start 240322 13:10
     * 문제
     * n개의 행성이 주어지고 모든 행성을 연결할때 관리 비용이 최소가 되는 경우의
     * 관리 비용을 출력하라
     * 
     * 해결방법
     * 크루스칼 알고리즘을 활용하여 MST를 찾고 비용의 최소 값을 반환
     * 13:16=> success
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
            if(o.val == val){
                return start - o.start;
            }
            return val - o.val;
        }
    }
    static int[] parent;
    static int[] rank;
    static int find(int num){
        if(num == parent[num]){
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
                rank[rootA] ++;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int val = Integer.parseInt(st.nextToken());
                if(i == j){
                    continue;
                }
                pq.add(new Edge(i, j, val));
            }
        }
        int cnt = 1;
        long ans = 0;
        while(cnt < n){
            Edge now = pq.poll();
            int start = now.start;
            int end = now.end;
            int val = now.val;
            if(union(start, end)){
                cnt++;
                ans += val;
            }
        }    
        System.out.println(ans);
    }
    
}
