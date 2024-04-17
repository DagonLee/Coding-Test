package boj.Graph;

import java.io.*;
import java.util.*;
public class boj17070 {
    /*
     * 240417 08:57
     * 문제
     * 파이프의 놓아서 경우의 수를 세는 문제
     * 
     * 해결방법
     * dfs 를 이용하여 파이프가 n - 1,n - 1 에 도착하는 경우를 센다.
     * success 09:17
     */
    static int cnt = 0;
    static int n;
    static void backtrack(boolean[][] map, int x, int y, int dir){ // dir: 가로 : 0, 대각 : 1, 세로 : 2
        if(x == n - 1 && y == n - 1){
            cnt++;
            return;
        }
        if((dir == 0 || dir == 1) &&y + 1 < n && !map[x][y + 1]){
            map[x][y + 1] = true;
            backtrack(map, x, y + 1, 0);
            map[x][y + 1] = false;
        }
        if((dir == 1 || dir == 2) &&x + 1 < n && !map[x + 1][y]){
            map[x + 1][y] = true;
            backtrack(map, x + 1, y, 2);
            map[x + 1][y] = false;
        }
        if(x + 1 < n && y + 1 < n && !map[x + 1][y + 1] && !map[x][y + 1] && !map[x + 1][y]){
            map[x + 1][y + 1] = true;
            map[x][y + 1] = true;
            map[x + 1][y] = true;
            backtrack(map, x + 1, y + 1, 1);
            map[x + 1][y + 1] = false;
            map[x][y + 1] = false;
            map[x + 1][y] = false;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int val = Integer.parseInt(st.nextToken());
                if(val == 1){
                    map[i][j] = true;
                }
            }
        }
        map[0][0] = true;
        map[0][1] = true;
        backtrack(map, 0, 1, 0);
        System.out.println(cnt);
    }
}
