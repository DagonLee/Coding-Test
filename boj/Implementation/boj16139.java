package boj.Implementation;

import java.io.*;
import java.util.*;

public class boj16139 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int T = Integer.parseInt(br.readLine());
        int[][] alphas = new int[33][str.length()];
            for(int i = ('a' - 'a'); i <= ('z' - 'a'); i++){
                if(('a' + i) == str.charAt(0)){
                    alphas[i][0] = 1;
                }
                for(int j = 1; j < str.length(); j++){
                    alphas[i][j] = alphas[i][j - 1];
                    if(str.charAt(j) == ('a' + i)){
                        alphas[i][j]++;
                    }
                }
            }
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char alpha = st.nextToken().charAt(0);
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(s > 0){
                sb.append((alphas[alpha - 'a'][e] - alphas[alpha - 'a'][s - 1])  + "\n");
            }
            else{
                sb.append((alphas[alpha - 'a'][e]) + "\n");
            }
            
        }
        System.out.println(sb.toString());
    }
}
