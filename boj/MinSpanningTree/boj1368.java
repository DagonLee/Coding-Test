package boj.MinSpanningTree;

import java.io.*;
import java.util.*;

public class boj1368 {
    /*
     * 240321 15:03
     * 문제
     * n개의 논에 물을 대려고한다.
     * 직접 물을 파는 것 또 하나는 다른 논으로 부터 물을 끌어오는 법 2가지가 존재.
     * 모든 논에 물을 대는데 필요한 최소 비용을 출력하라
     * 
     * 해결방법
     * 모든 노드를 연결하는 것 => MST로 생각
     * 하지만 직접 물을 파는 것에 대한 처리 방법을 생각해내지 못하여 강의록을 정독
     * 가상의 논을 만들고 직접 파는 것을 가상의 논과의 연결이라고 생각하면된다.
     * 
     * 프림 알고리즘으로 구현
     */
    static class Node implements Comparable<Node>{
        int dest;
        int val;
        Node(int dest, int val){
            this.dest = dest;
            this.val = val;
        }
        public int compareTo(Node o){
            if(val == o.val){
                return dest - o.dest;
            }
            return val - o.val;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Node>[] adj = new ArrayList[n + 2];
        for(int i = 1; i <= (n + 1); i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i <= n; i++){
            int val = Integer.parseInt(br.readLine());
            adj[i].add(new Node(n + 1, val));
            adj[n + 1].add(new Node(i, val));
        }
        
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                int val = Integer.parseInt(st.nextToken());
                if(j == i){
                    continue;
                }
                adj[i].add(new Node(j, val));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] checked = new boolean[n + 2];
        int cnt = 1;
        checked[1] = true;
        int ans = 0;
        for(Node nxt : adj[1]){
            pq.add(nxt);
        }
        while(cnt < (n + 1)){
            Node now = pq.poll();
            if(checked[now.dest]){
                continue;
            }
            checked[now.dest] = true;
            ans += now.val;
            cnt++;
            for(Node nxt : adj[now.dest]){
                if(!checked[nxt.dest]){
                    pq.add(nxt);
                }
            }
        }
        System.out.println(ans);
    }
}
