package boj.Graph;

import java.io.*;
import java.util.*;

public class boj1743 {
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m, k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n][m];
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = true;
        }
        boolean[][] checked = new boolean[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j]){
                    map[i][j] = false;
                    int cnt = 1;
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    q.addLast(new int[]{i, j});
                    while(!q.isEmpty()){
                        int[] now = q.pollFirst();
                        for(int d = 0; d< 4; d++){
                            int nx = now[0] + dx[d];
                            int ny = now[1] + dy[d];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                                continue;
                            }
                            if(!map[nx][ny]){
                                continue;
                            }
                            map[nx][ny] = false;
                            q.add(new int[]{nx, ny});
                            cnt++;
                        }
                    }
                    ans = Math.max(ans, cnt);
                }
            }
        }
        System.out.println(ans);
    }
}
