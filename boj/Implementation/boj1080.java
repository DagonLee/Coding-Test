package boj.Implementation;
import java.io.*;
import java.util.*;

public class boj1080 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][][] datas = new int[2][n][m];
        for(int t = 0; t < 2; t++){
            for(int i = 0; i < n; i++){
                char[] input = br.readLine().toCharArray();
                for(int j = 0; j < m; j++){
                    datas[t][i][j] = input[j] - '0';
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i <= n - 3; i++){
            for(int j = 0; j <= m - 3; j++){
                if(datas[0][i][j] != datas[1][i][j]){
                    cnt++;
                    for(int r = 0; r < 3; r++){
                        for(int c = 0; c < 3; c++){
                            datas[0][i + r][j + c] = Math.abs(datas[0][i + r][j + c] - 1);
                        }
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(datas[0][i][j] != datas[1][i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(cnt);
    }
}
