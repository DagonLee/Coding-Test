package boj.BruteForce;
import java.io.*;
import java.util.*;
public class boj1389 {
    /*
     * start 240224 11:03
     * 문제
     * 사람들 기리의 연결이 주어지고
     * 각 사람마다 한사람과 모든 사람을 연결 하고자 할때 거쳐가는 사람이 가장 적은 사람을 구하라
     * 
     * 해결방법
     * 각 사람 별로 bfs 를 시작, visited 배열을 int로 두어 거쳐가는 사람 수를 구한다.
     *  
     * 11:25
     * 단계를 계산할때 큐에 넣어주지 않는다면 첫 큐에 들어갈 경우에만 알맞은 단계가 적용된다.
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        for(int i = 1; i<= n; i++){
            adjList[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjList[s].add(e);
            adjList[e].add(s);
        }
        int dist = Integer.MAX_VALUE;
        int name = 0;
        for(int i = 1; i <= n; i++){
            Deque<int[]> dq = new ArrayDeque<>();
            int[] visited = new int[n + 1];
            visited[i] = -1;
            dq.offerLast(new int[]{i, 0});
            while(!dq.isEmpty()){
                int[] now = dq.pollFirst();
                for(int next : adjList[now[0]]){
                    if(visited[next] == 0){
                        visited[next] = now[1] + 1;
                        dq.offerLast(new int[]{next, now[1] + 1});
                    }
                }
            }
            int sum = 0;
            for(int val : visited){
                if(val > 0){
                    sum += val;
                }
            }
            if(dist > sum){
                dist = sum;
                name = i;
            }
            // System.out.println("단계 : " + i);
            // for(int j = 1; j <= n; j++){
            //     System.out.print( " 거리 " + visited[j] + " ");
            // }
            // System.out.println();
        }
        System.out.println(name);
    }
}
