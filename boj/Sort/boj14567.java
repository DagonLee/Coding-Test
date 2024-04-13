package boj.Sort;

import java.io.*;
import java.util.*;

public class boj14567 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] degree = new int[n + 1];
        int[] ans = new int[n + 1];
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            degree[b]++;
        }
        int cnt = 0;
        int layer = 1;
        boolean[] checked = new boolean[n + 1];
        while(cnt != n){
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for(int i = 1; i <= n; i++){
                if(degree[i] == 0 && !checked[i]){
                    cnt++;
                    checked[i] = true;
                    for(int nxt : adj[i]){
                        q.add(nxt);
                    }
                    ans[i] = layer;
                }
            }
            while(!q.isEmpty()){
                int nxt = q.poll();
                degree[nxt]--;
            }
            layer++;
        }
        for(int i = 1; i <= n; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
