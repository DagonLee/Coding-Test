package boj.Graph;

import java.io.*;
import java.util.*;

public class boj3184 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r, c;
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];
        boolean[][] checked = new boolean[r][c];
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        for(int i = 0; i < r; i++){
            map[i] = br.readLine().toCharArray();
        }
        int total_sheeps = 0;
        int total_wolves = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] != '#' && !checked[i][j]){
                    checked[i][j] = true;
                    int sheeps = 0;
                    int wolves = 0;
                    if(map[i][j] == 'o'){
                        sheeps++;
                    }
                    else if(map[i][j] == 'v'){
                        wolves++;
                    }
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    q.addLast(new int[]{i, j});
                    while(!q.isEmpty()){
                        int[] now = q.pollFirst();
                        for(int d = 0; d < 4; d++){
                            int nx = now[0] + dx[d];
                            int ny = now[1] + dy[d];
                            if(nx < 0 || r <= nx || ny < 0 || c <= ny){
                                continue;
                            }
                            if(checked[nx][ny]){
                                continue;
                            }
                            if(map[nx][ny] == '#'){
                                continue;
                            }
                            if(map[nx][ny] == 'o'){
                                sheeps ++;
                            }
                            else if(map[nx][ny] == 'v'){
                                wolves++;
                            }
                            q.add(new int[]{nx, ny});
                            checked[nx][ny] = true;
                        }
                    }
                    if(sheeps > wolves){
                        total_sheeps += sheeps;
                    }
                    else{
                        total_wolves += wolves;
                    }
                }
            }
        }
        System.out.println(total_sheeps + " " + total_wolves);
    }
}
