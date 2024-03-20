package boj.Sort;

import java.io.*;
import java.util.*;

public class boj2623 {
    /*
     * start 240320 08:46
     * 문제
     * m개의 출연 순서가 주어질때 최종적인 출연순서를 출력하라
     * 
     * 해결방법
     * 위상정렬을 이용하되 이미 방문한 경우라면 0을 출력하도록한다.
     * 09:09 한번 실패 이후 질문게시판의 반례 힌트를 얻어서 해결
     * 일반 적인 위상 정렬에 사이클에 대한 예외처리가 필요
     * 1. 주어진 순서에서 사이클이 존재하는 경우 => 위상 정렬 탐색 큐에 들어가는 수가 없다. 
     * 2. 이미 방문한 번호를 다시 방문하는 경우 => 사이클이 생성되므로 최종 결과 리스트에 모든 번호가 들어있지 않는 경우 처리
     * 
     * 핵심
     * 위상 정렬 후 결과 리스트의 크기가 주어진 번호의 개수와 같지 않다면 사이클이 존재하는 것
     * 
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        int[] deg = new int[n + 1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            if(val >= 2){
                int prev = Integer.parseInt(st.nextToken());
                for(int j = 1; j < val; j ++){
                    int next = Integer.parseInt(st.nextToken());
                    adj[prev].add(next);
                    prev = next;
                    deg[next]++;
                }
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            if(deg[i] == 0){
                q.addLast(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            int now = q.pollFirst();
            result.add(now);
            for(int nxt : adj[now]){
                deg[nxt] --;
                if(deg[nxt] == 0){
                    q.addLast(nxt);
                }
            }
        }
        if(result.size() != n){
            System.out.println(0);
            return;
        }
        for(int i : result){
            System.out.println(i);
        }
    }
}
