package boj.Implementation;

import java.io.*;
import java.util.*;

class boj1105{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l, r;
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        int cnt = Integer.MAX_VALUE;
        for(int i = l; i <= r; i++){
            char[] cur = Integer.toString(i).toCharArray();
            int tmp = 0;
            for(char c : cur){
                if(c == '8'){
                    tmp++;
                }
            }
            if(tmp == 0){
                System.out.println(0);
                return;
            }
            else if(cnt > tmp){
                cnt = tmp;
            }
        }
        System.out.println(cnt);

    }
}