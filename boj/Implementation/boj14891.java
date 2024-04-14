package boj.Implementation;

import java.io.*;
import java.util.*;

public class boj14891 {
    static int[][] cycles = new int[4][8];
    static void rotate(int cur, int state){
        if(state == 1){
            int tmp = cycles[cur][7];
            for(int i = 7; i > 0; i--){
                cycles[cur][i] = cycles[cur][i - 1];
            }
            cycles[cur][0] = tmp;
        }
        else if(state == -1){
            int tmp = cycles[cur][0];
            for(int i = 0; i < 7; i++){
                cycles[cur][i] = cycles[cur][i + 1];
            }
            cycles[cur][7] = tmp;
        }
        else{
            return;
        }
    }
    static void checkAndRotate(int start, int state){
        int[] rotateState = new int[4];
        rotateState[start] = state;
        int leftState = state;
        int rightState = state;
        for(int i = start; i < 3; i++){
            if(cycles[i][2] != cycles[i + 1][6]){
                leftState *= -1;
                rotateState[i + 1] = leftState;
            }
            else{
                break;
            }
        }
        for(int i = start; i > 0; i--){
            if(cycles[i][6] != cycles[i - 1][2]){
                rightState *= -1;
                rotateState[i - 1] = rightState;
            }
            else{
                break;
            }
        }
        for(int i = 0; i < 4; i++){
            rotate(i, rotateState[i]);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 4; i++){
            char[] state = br.readLine().toCharArray();
            for(int j = 0; j < 8; j++){
                cycles[i][j] = state[j] - '0';
            }
        }
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int state = Integer.parseInt(st.nextToken());
            checkAndRotate(cur - 1, state);
        }
        int ans = 0;
        int score = 1;
        for(int i = 0; i < 4; i++){
            if(cycles[i][0] == 1){
                ans += score;
            }
            score *= 2;
        }
        System.out.println(ans);
        
    }
}
