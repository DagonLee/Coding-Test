package boj.BruteForce;
import java.io.*;
import java.util.*;
public class boj1260 {
    static int n, m;
    static ArrayList<Integer>[] adj;
    public static void dfs(int num, boolean[] checked){
        System.out.print(num + " ");
        for(int cur : adj[num]){
            if(checked[cur]){
                continue;
            }
            checked[cur] = true;
            dfs(cur, checked);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start].add(end);
            adj[end].add(start);
        }
        for(int i = 1; i <= n; i++){
            Collections.sort(adj[i]);
        }
        boolean[] checked = new boolean[n + 1];
        checked[v] = true;
        dfs(v, checked);
        Deque<Integer> q = new ArrayDeque<>();
        q.add(v);
        checked = new boolean[n + 1];
        System.out.println();
        checked[v] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            System.out.print(now+ " ");
            for(int n : adj[now]){
                if(checked[n]){
                    continue;
                }
                checked[n] = true;
                q.add(n);
            }
        }
    }
}
