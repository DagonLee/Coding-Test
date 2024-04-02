package boj.DisjointSet;

import java.io.*;
import java.util.*;

public class boj1717 {
    static int[] rank;
    static int[] parent;
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

    static int find(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        rank = new int[n + 1];
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int com = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(com == 0){
                union(a, b);
            }
            else if(com == 1){
                int rootA = find(a);
                int rootB = find(b);
                if(rootA == rootB){
                    System.out.println("yes");
                }
                else{
                    System.out.println("no");
                }
            }
        }
    }
}
