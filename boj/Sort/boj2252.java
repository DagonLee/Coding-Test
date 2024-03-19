package boj.Sort;

import java.io.*;
import java.util.*;

public class boj2252 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>();
        }
        int[] input = new int[n + 1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            input[b] ++;
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            if(input[i] == 0){
                q.addLast(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            int now = q.pollFirst();
            result.add(now);
            for(int nxt : adj[now]){
                input[nxt]--;
                if(input[nxt] == 0){
                    q.addLast(nxt);
                }
            }
        }
        for(int num : result){
            System.out.print(num + " ");
        }
    }
}
