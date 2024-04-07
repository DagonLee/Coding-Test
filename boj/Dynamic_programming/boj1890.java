package boj.Dynamic_programming;

import java.io.*;
import java.util.*;

public class boj1890 {
    static int cnt = 0;
    static int n;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        long[][] cnt = new long[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        map[n - 1][n - 1] = -1;
        cnt[0][0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int move = map[i][j];
                boolean canGoRight = true;
                boolean canGoDown = true;

                if(j + move < n){
                    for(int k = 1; k <= move; k++){
                        if(map[i][j + k] == 0){
                            canGoRight = false;
                            break;
                        }
                    }
                }
                else{
                    canGoRight = false;
                }

                if(i + move < n){
                    for(int k = 1; k <= move; k++){
                        if(map[i + k][j] == 0){
                            canGoDown = false;
                            break;
                        }
                    }
                }
                else{
                    canGoDown = false;
                }
                if(canGoDown){
                    cnt[i + move][j] += cnt[i][j];
                }
                if(canGoRight){
                    cnt[i][j + move] += cnt[i][j];
                }
            }
        }
        // for(int i = 0; i < n; i++){
        //     System.out.println(Arrays.toString(cnt[i]));
        // }
        System.out.println(cnt[n - 1][n - 1]);
    }
}
