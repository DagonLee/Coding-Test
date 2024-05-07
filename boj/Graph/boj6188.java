package boj.Graph;

import java.io.*;
import java.util.*;

class boj6188{
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] trees = new ArrayList[n + 1];
        int[] distance = new int[n + 1];
        for(int i = 1; i <= n; i++){
            distance[i] = -1;
            trees[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            trees[a].add(b);
            trees[b].add(a);
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(1);
        distance[1] = 0;
        while(!q.isEmpty()){
            int now = q.pollFirst();
            for(int nxt : trees[now]){
                if(distance[nxt] == -1){
                    distance[nxt] = (distance[now] + 1);
                    q.add(nxt);
                }
            }
        }
        int ans = 0;
        int cnt = 0;
        int val = -1;
        for(int i = 1; i <= n; i++){
            if(distance[i] > val){
                val = distance[i];
                cnt = 1;
                ans = i;
            }
            else if(distance[i] == val){
                cnt++;
            }
        }
        System.out.println(ans + " " + val + " " + cnt);
    }
}