package boj.BackTracking;

import java.io.*;
import java.util.*;

public class boj1189 {
    static int r, c, k;
    static int[][] map;
    static int cnt = 0;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static void calculate(int x, int y, int step){
        if(x == 0 && y == c - 1 && step == k ){
            cnt++;
            
            return;
        }

        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= r || ny < 0 || ny >= c){
                continue;
            }
            if(map[nx][ny] != -1){
                continue;
            }

            int tmp = map[nx][ny];
            map[nx][ny] = step;
            
            calculate(nx, ny, step + 1);
            map[nx][ny] = tmp;
        }


    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        for(int i = 0; i < r; i++){
            char[] datas = br.readLine().toCharArray();
            for(int j = 0; j < c; j++){
                if(datas[j] == '.'){
                    map[i][j] = -1;
                }
                else if(datas[j] == 'T'){
                    map[i][j] = -2;
                }
            }
        }
        if(r == 1 && c == 1){
            System.out.println(1);
            return;
        }
        map[r - 1][0] = 0;
        calculate(r - 1, 0, 1);
        System.out.println(cnt);
    }
}
