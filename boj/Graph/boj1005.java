package boj.Graph;
import java.io.*;
import java.util.*;
public class boj1005 {
    /*
     * 240323 21:17
     * 문제
     * 건설순서에 대한 규칙 k가 주어질때 마지막 건물인 w를 지을때가지 걸리는 최소 시간을 출력하라
     * 건물의 개수 n이 주어진다.
     * 
     * 해결방법
     * 순서 => 위상 정렬?
     * w 지점 부터 다음 연결 노드 중 최대 건설 시간이 걸리는 시간을 더해가면서 추가
     * 
     * 1 -> 3
     *   -> 2 -> 4
     *        -> 3
     *              -> 4 -> 5
     *              -> 5
     *        -> 5
     * 
     *   -> 4
     *   -> 5
     * 모르겠다.. 21:57
     * 위상 정렬을 이용한 방법을 사용하는 듯한데.. 
     * 문제 상에서 노드가 중복되서 사용 되는 경우에 대해서 언급을 안했기에 
     * 잘 못 생각한 듯하다.. 일단 구현 시작 22:04
     * 구현 완료 22:16, 다시 생각해보니 각 건물이 여러번 지어지는 경우도 존재할 수 있겠다..
     * DP 형식으로 이전의 건물이 지어지는 시간을 저장하면서 위상정렬을 수행
     */
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n, k;
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            int[] time = new int[n + 1];
            ArrayList<Integer>[] adj = new ArrayList[n + 1];
            for(int i = 1; i <= n; i++){
                adj[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++){
                time[i] = Integer.parseInt(st.nextToken());
            }
            int [] deg = new int[n + 1];
            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                deg[b]++;
            }
            int w = Integer.parseInt(br.readLine());
            int[] cost = new int[n + 1];
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for(int i = 1; i <= n; i++){
                if(deg[i] == 0){
                    q.addLast(i);
                }
            }
            while(!q.isEmpty()){
                Integer now = q.pollFirst();
                cost[now] += time[now];
                for(int nxt : adj[now]){
                    cost[nxt] = Math.max(cost[nxt], cost[now]);
                    deg[nxt]--;
                    if(deg[nxt] == 0){
                        q.addLast(nxt);
                    }
                }
            }
            sb.append(cost[w] + "\n");
        }
        System.out.println(sb.toString());
    }
}
