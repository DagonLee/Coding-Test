package boj.DisjointSet;

import java.io.*;
import java.util.*;

public class boj16562 {
    /*
     * 문제
     * 가장 적은 비용으로 모든 사람과 친구가 되는 방법을 구하라
     * 
     * 해결방법
     * 비용의 최소가 되는 친구비용의 친구를 부모 노드로 하여 union-find 갱신
     */
    static int[] parent;
    static int[] cost;
    static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB){
            return false;
        }
        if(cost[rootA] <= cost[rootB]){
            parent[rootB] = rootA;
        }
        else{
            parent[rootA] = rootB;
        }
        return true;
    }

    static int find(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m, k;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        cost = new int[n + 1];
        for(int i = 1; i<= n; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
       
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(find(0) != find(i)){
                ans += cost[find(i)];
                union(0, i);
            }
        }
        if(ans <= k){
            System.out.println(ans);
        }
        else{
            System.out.println("Oh no");
        }
    }
}
