package boj.Greedy;

import java.io.*;
import java.util.*;

public class boj19941 {
    //start 16:26 ~ 16:50
    // 1. 사람이라면 k 범위안에 햄버거가 있는지 확인 있다면 ans +1
    // 2. 다만 우선순위는 왼쪽부터
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int ans = 0;
        String str = br.readLine();
        boolean[] hasHamburg = new boolean[n];
        for(int i = 0; i < n; i++){
            char c = str.charAt(i);
            if(c == 'H'){
                hasHamburg[i] = true;
            }
        }

        for(int i = 0; i < n; i++){
            char c = str.charAt(i);
            if(c == 'P'){
                boolean canEat = false;
                int start = Math.max(i - k, 0); // 시작점
                while(0 <= start && start <= Math.min(n - 1, i + k)){
                    if(start == i){
                        start++;
                    }
                    else if(str.charAt(start) == 'H' && hasHamburg[start]){
                        canEat = true;
                        hasHamburg[start] = false;
                        break;
                    }
                    else{
                        start ++;
                    }
                }
                if(canEat){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
