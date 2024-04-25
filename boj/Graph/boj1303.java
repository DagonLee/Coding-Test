package boj.Graph;

import java.io.*;
import java.util.*;

public class boj1303 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        char[][] map = new char[m][n];
        boolean[][] checked = new boolean[m][n];
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        for(int i = 0; i < m; i++){
            map[i] = br.readLine().toCharArray();
        }
        int mine = 0;
        int enemies = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!checked[i][j]){
                    checked[i][j] = true;
                    char type = map[i][j];
                    int cnt = 1;
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    q.addLast(new int[]{i, j});
                    while(!q.isEmpty()){
                        int[] now = q.pollFirst();
                        for(int d = 0; d < 4; d++){
                            int nx = now[0] + dx[d];
                            int ny = now[1] + dy[d];
                            if(nx < 0 || m <= nx || ny < 0 || n <= ny){
                                continue;
                            }
                            if(map[nx][ny] != type){
                                continue;
                            }
                            if(checked[nx][ny]){
                                continue;
                            }
                            cnt++;
                            q.addLast(new int[]{nx, ny});
                            checked[nx][ny] = true;
                        }
                    }
                    if(type == 'W'){
                        mine += (cnt * cnt);
                    }
                    else{
                        enemies += (cnt * cnt);
                    }
                }
            }
        }
        System.out.println(mine + " " + enemies);
    }
}
