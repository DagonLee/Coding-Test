package boj.Implementation;

import java.io.*;
import java.util.*;

public class boj16918 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int r, c, n;
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[][] map = new int[r][c];
        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                char type = s.charAt(j);
                if(type == 'O'){
                    map[i][j] = 0;
                }
                else{
                    map[i][j] = -1;
                }
            }
        }
        int time = 2;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        Deque<int[]> q = new ArrayDeque<>();
        while(time <= n){
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    if(map[i][j] != -1 && map[i][j] + 3 == time){
                        q.addLast(new int[]{i, j});
                    }
                    if(map[i][j] == -1){
                        map[i][j] = time;
                    }
                    
                }
            }
            while(!q.isEmpty()){
                int[] now = q.pollFirst();
                map[now[0]][now[1]] = -1;
                for(int d = 0 ; d < 4; d++){
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];
                    if(nx < 0 || nx >= r || ny <0 || ny >= c){
                        continue;
                    }
                    map[nx][ny] = -1;
                }
            }
            
            time++;            
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] != -1){
                    System.out.print("O");
                }
                else{
                    System.out.print('.');
                }
            }
            System.out.println();
        }

    }
}
