package boj.MinSpanningTree;

import java.io.*;
import java.util.*;

public class boj1197 {
    /*
     * 240321 10:40
     * 문제
     * 최소 스패닝 트리를 구하는 프로그램 작성
     * 
     * 해결방법
     * 프림 알고리즘을 사용하여 해결
     * 1st fail => 양방향으로 그래프를 저장하지 않아서 생긴 오류
     * 10:51 => success
     */
    static class Node implements Comparable<Node>{
        int dest;
        long val;
        Node(int dest, long val){
            this.dest = dest;
            this.val = val;
        }
        public int compareTo(Node o){
            if(o.val == this.val){
                return dest - o.dest;
            }
            return Long.compare(val, o.val);

        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v, e;
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        ArrayList<Node>[] adj = new ArrayList[v + 1];
        for(int i = 1; i <= v; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int cnt = 1;

        boolean[] checked = new boolean[v + 1];
        checked[1] = true;
        int ans = 0;
        for(Node nxt : adj[1]){
            pq.add(nxt);
        }
        while(cnt < v){
            Node now = pq.poll();
            if(checked[now.dest]){
                continue;
            }
            cnt++;
            ans += now.val;
            checked[now.dest] = true;
            for(Node nxt : adj[now.dest]){
                if(!checked[nxt.dest]){
                    pq.add(nxt);
                }
            }
        }
        System.out.println(ans);
    }
}
