package boj.Dijkstra;

import java.io.*;
import java.util.*;
public class boj5972 {
    /*
     * start 240214 10:25
     * 문제
     * 그래프가 주어지고 최소한의 비용으로 
     * 선택된 노드를 방문하는 방법을 구하시오
     * 
     * 입력
     * int n // 헛간 개수
     * int m // 간선 개수
     * 연결된 헛간 a와 b, 가중치 가 한줄로 m개 주어진다.
     * 
     * 데이터
     * ArrayList<Int[]>[] adjList// 간선 리스트, 0번에는 연결된 헛간, 1번에는 가중치 저장
     * int[] dist // 각 노드의 거리를 기록
     * 해결방법
     * 1. BFS를 사용하여 탐색, 1번 노드 부터 시작
     * 2. 만약, dist에 기록된 거리가 0이거나 이전 누적 가중치 + 현재 이동 가중치 보다 큰 경우에만 갱신하고 계속 탐색
     *    1번은 방문하지 않도록 해야한다.
     * 3. 모든 노드를 방문하고 n번 노드의 가중치를 반환
     * 
     * 11:00 => memory exceeded
     * 
     * 검색을 통해서 해결
     * 문제점
     * bfs를 deque로 순회할 시 메모리 초과가 난다.
     * PriorityQueue 를 사용
     * 간선의 가중치가 있는 경우에는 노드 클래스를 선언하여 관리하는 것이 좋을 듯 하다.
     * 다익
     * 11:15 => success
     * 
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] dist = new int[n + 1];
        ArrayList<int[]>[] adjList = new ArrayList[n + 1];
        for(int i = 1; i<= n; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[e].add(new int[]{s, v});
            adjList[s].add(new int[]{e, v});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);;
        q.add(new int[]{1, 0});
        for(int i = 1; i<= n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int[] next: adjList[now[0]]){
                int dest = next[0];
                int val = next[1];
                if(dist[now[0]] + val > dist[dest]){
                    dist[dest] = dist[now[0]] + val;
                    q.add(new int[]{dest, dist[dest]});
                }
            }
        }
        System.out.println(dist[n]);
    }
}