package boj.BruteForce;
import java.io.*;
import java.util.*;
public class boj1976 {
    /*
     * start 240223
     * 문제
     * 도시 n개와 그 연결 상태가 주어진다.
     * 그리고 여행 계획이 주어질때
     * 그 여행 계획이 가능한지 여부를 출력하라
     * 
     * 해결방법
     * 1. 방문해야하는 여행지를 리스트에 넣는다.
     * 2. 첫 여행지를 기준으로 bfs 를 사용하여 방문 가능한 도시들을 모두 체크
     * BFS로 해결,
     * 큐에 i를 넣어서 틀림, 그래프 탐색 시 출력을 해볼 것
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] adj = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] mustGo = new int[m];
        for(int i = 0; i < m; i++){
            mustGo[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        boolean[] visited = new boolean[n];
        visited[mustGo[0]] = true;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(mustGo[0]);
        while(!dq.isEmpty()){
            int now = dq.pollFirst();
            for(int i = 0; i < n; i++){
                int next = adj[now][i];
                if(next == 1 && !visited[i]){
                    visited[i] = true;
                    dq.add(i);
                }
            }
        }
        for(int node : mustGo){
            if(!visited[node]){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
