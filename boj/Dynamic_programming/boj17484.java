package boj.Dynamic_programming;

import java.io.*;
import java.util.*;
public class boj17484 {
    // start : 16:08
    // fail : 
    // saw answer : 17:16 
    // dp문제
    // 1번 행부터 내려가면서 바로 위의 행에서 내려올 수 있는 값들 중 
    // 가장 작은 값을 자신에게 더한다.
    // 이전에 움직인 방햐으로 못 움직임 => 두번 연속 불가
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r, c;
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int [][][] map = new int[r][c][3];
        int[][] source = new int[r][c];
        for(int i = 0; i < r; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++){
                    int val = Integer.parseInt(st.nextToken());
                    source[i][j] = val;
                    
            }
        }
        for(int i = 0; i< c; i++){
            for(int k = 0; k < 3; k++){
                map[0][i][k] = source[0][i];
            }
        }
        for(int i = 1; i < r; i++){
            map[i][0][0] = Integer.MAX_VALUE;
            map[i][c - 1][2] = Integer.MAX_VALUE;
            for(int j = 0; j < c; j++){
                if(j == 0){
                    map[i][j][1] = Math.min(map[i - 1][j][0], map[i - 1][j][2]) + source[i][j];
                    map[i][j][2] = Math.min(map[i - 1][j + 1][0], map[i - 1][j + 1][1]) + source[i][j];
                }
                else if(j == c - 1){
                    map[i][j][0] = Math.min(map[i - 1][j - 1][1], map[i - 1][j - 1][2]) + source[i][j];
                    map[i][j][1] = Math.min(map[i - 1][j][0], map[i - 1][j][2]) + source[i][j];
                }
                else{
                    map[i][j][0] = Math.min(map[i - 1][j - 1][1], map[i - 1][j - 1][2]) + source[i][j];
                    map[i][j][1] = Math.min(map[i - 1][j][0], map[i - 1][j][2]) + source[i][j];
                    map[i][j][2] = Math.min(map[i - 1][j + 1][0], map[i - 1][j + 1][1]) + source[i][j];
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < c; j++){
            for(int k = 0; k < 3; k++){
                ans = Math.min(ans, map[r - 1][j][k]);
            }
        }
        // System.out.println();
        // for(int i = 0; i < r; i++){
        //     for(int j = 0; j < c; j++){
        //         System.out.print(map[i][j][1] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println(ans);
    }
}
