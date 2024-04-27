package boj.Implementation;

import java.io.*;
import java.util.*;

public class boj2615 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[19][19];
        boolean[][][] check = new boolean[19][19][4];
        for(int i = 0; i < 19; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                if(map[i][j] != 0){
                    int type = map[i][j];
                    //가로
                    boolean row = true;
                    if(!check[i][j][0]){
                        for(int r = 1; r <= 4; r++){
                            if(19 <= i + r || map[i + r][j] != type){
                                row = false;
                                break;
                            }
                        }
                        if(row == true && i + 5 < 19 && map[i + 5][j] == type){
                            row = false;
                            int r = 0;
                            while(i + r < 19 && map[i + r][j] == type){
                                check[i + r][j][0] = true;
                                r++;
                            }
                        }
                    }
                    else{
                        row = false;
                    }

                    // 세로 
                    boolean col = true;
                    if(!check[i][j][1]){
                        for(int c = 1; c <= 4; c++){
                            if(19 <= j + c || map[i][j + c] != type){
                                col = false;
                                break;
                            }
                        }
                        if(col == true && j + 5 < 19 && map[i][j + 5] == type){
                            col = false;
                            int c = 0;
                            while(j + c < 19 && map[i][j + c] == type){
                                check[i][j + c][1] = true;
                                c++;
                            }
                        }
                    }
                    else{
                        col = false;
                    }
                    

                    // 대각 우하향
                    boolean d_diag = true;
                    if(!check[i][j][2]){
                        for(int d = 1; d <= 4; d++){
                            if(19 <= i + d || 19 <= j + d || map[i + d][j + d] != type){
                                d_diag = false;
                                break;
                            }
                        }
                    
                        if(d_diag == true && (i + 5 < 19 && j + 5 < 19) && map[i + 5][j + 5] == type){
                            d_diag = false;
                            int d = 0;
                            while((i + d < 19) && (j + d < 19) && map[i + d][j + d] == type){
                                check[i + d][j + d][2] = true;
                                d++;
                            }
                        }
                    }
                    else{
                        d_diag = false;
                    }

                    // 대각 좌 하향
                    boolean l_diag = true;
                    if(!check[i][j][3]){
                        for(int d = 1; d<= 4; d++){
                            if(i + d >= 19 || j - d < 0 || map[i + d][j - d] != type){
                                l_diag = false;
                                break;
                            }
                        }
                        if(l_diag == true && (i + 5 < 19 && (j - 5 >= 0) && map[i + 5][j - 5] == type)){
                            l_diag = false;
                            int d = 0;
                            while((i + d < 19) && (j - d >= 0) && map[i + d][j - d] == type){
                                check[i + d][j - d][3] = true;
                                d++;
                            }
                        }
                    }
                    else{
                        l_diag = false;
                    }

                    if(row || col || d_diag || l_diag){
                        System.out.println(type);
                        if(l_diag){
                            System.out.println((i + 1 + 4) + " " + (j + 1 - 4));

                        }
                        else{
                            System.out.println((i + 1) + " " + (j + 1));
                        }
                        
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}
