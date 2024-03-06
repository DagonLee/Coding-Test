package boj.Graph;

import java.io.*;
import java.util.*;
public class boj21736 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m; 
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        char[][]map = new char[n][m];

        for(int i = 0; i < n; i++){
            map[i] = br.readLine().toCharArray();
        }

        int sx = 0;
        int sy = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 'I'){
                    sx = i;
                    sy = j;
                }
            }
        }
        boolean[][] visited = new boolean[n][m];
        visited[sx][sy] = true;
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[]{sx, sy});
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int cnt = 0;
        while(!q.isEmpty()){
            int[] now = q.pollFirst();
            for(int d = 0; d < 4; d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if(nx < 0 || n <= nx || ny < 0 || m <= ny){
                    continue;
                }
                if(visited[nx][ny]){
                    continue;
                }
                if(map[nx][ny] == 'X'){
                    continue;
                }
                visited[nx][ny] = true;
                if(map[nx][ny] == 'P'){
                    cnt++;
                }
                q.add(new int[]{nx, ny});
            }
        }
        if(cnt == 0){
            System.out.println("TT");
        }else{
            System.out.println(cnt);
        }
    }
}
