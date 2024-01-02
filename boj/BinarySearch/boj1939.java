package boj.BinarySearch;

import java.io.*;
import java.util.*;

public class boj1939 {
    static ArrayList<Node>[] dist;
    static int n, m;
    static class Node{
        int dest;
        int val;
        Node(int dest, int val){
            this.dest = dest;
            this.val = val;
        }
    }
    static boolean canGo(int start, int end, int mid, boolean[] visited){
        visited[start] =true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int now = q.poll();
            if(now == end){
                return true;
            }
            for(int i = 0; i < dist[now].size(); i++){
                if(dist[now].get(i).val >= mid && visited[dist[now].get(i).dest]== false){
                    visited[dist[now].get(i).dest] = true;
                    q.add(dist[now].get(i).dest);
                }
            }    
        }
        
        return false;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        // 
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new ArrayList[n];
        for(int i = 0; i < n; i++){
            dist[i] = new ArrayList<Node>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a - 1].add(new Node(b - 1, c));
            dist[b - 1].add(new Node(a - 1, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        int left = 0;
        int right = 1000000000;
        int ans = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            if(canGo(start, end, mid, new boolean[n])){
                ans = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
