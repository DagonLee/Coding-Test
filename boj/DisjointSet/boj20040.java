package boj.DisjointSet;

import java.io.*;
import java.util.*;

public class boj20040{
    /*
     * start 240322 14:24
     * 
     * 문제
     * 두 점을 연결하는 과정을 진행한다. 처음으로 사이클이 완성되는 순간 게임은 종료.
     * 종료되는 차례를 출력하라
     * m번째 차례 까지 진행한 이후에도 종료되지 않았다면 0을 출력하라
     * 
     * 해결방법
     * union-find로 사이클이 완성되는 경우에는 차례를 출력
     * 아니라면 0을 출려하도록 구현
     */
    static int[] rank;
    static int[] parent;
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
        rank = new int[n];
        parent = new int[n];
        boolean finished = false;
        int ans = 0;
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(finished){
                continue;
            }
            if(union(a, b)){
                
            }
            else{
                ans = i;
                finished = true;
            }
        }
        System.out.println(ans);
    }
}