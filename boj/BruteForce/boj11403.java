package boj.BruteForce;
import java.io.*;
import java.util.*;
public class boj11403 {
    /*
     * 240305 09:11
     * 문제
     * 그래포가 주어질때 
     * 모든 정점 i,j에 대해서 i에서 j로 가는 양수인 경로가 있는지 확인하는 문제
     * 
     * 해결방법
     * 각 정점에 대해서 bfs로 도착 가능 여부를 저장한다.
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] map = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int [][] ans = new int[n][n];
        for(int i = 0; i < n; i++){
            int[] visited = new int[n];
            Deque<Integer> q = new ArrayDeque<>();
            q.add(i);
            while(!q.isEmpty()){
                int now = q.pollFirst();
                for(int j = 0; j < n; j++){
                    if(visited[j] == 1){
                        continue;
                    }
                    if(map[now][j] == 1){
                        visited[j] = 1;
                        q.offerLast(j);
                    }
                }
            }
            ans[i] = visited;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
