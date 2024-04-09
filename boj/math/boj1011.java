package boj.math;

import java.io.*;
import java.util.*;


public class boj1011 {
    /*
     * 문제
     * x지점 부터 정확히 y지점으로 이동하는데 필요한 작동 횟수의 최솟값을 구하라
     * 이 기계는 이전 이동이 k라 했을때, k-1, k, k + 1 을 이동할 수 있다.
     * y지점 직전에는 반드시 1광년으로 이동 해야한다.
     * 해결 방법
     * 1 + 2 + 3 + 2 + 1 이런 방식으로 이동하는 형태이므로
     * y = 1 => 1
     * y = 2 => 1 1
     * y = 3 => 1 1 1
     * y = 4 => 1 2 1
     * y = 5 => 1 2 1 1
     * y = 6 => 1 2 2 1
     * y = 7 => 1 2 1 2 1
     * y = 8 => 1 2 2 2 1
     * y = 9 => 1 2 3 2 1
     * y = 10=> 1 2 3 2 1
     * y = 11=> 1 2 3
     */
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            double res = Math.floor(2 * Math.sqrt(b - a) - 1e-9);
            sb.append((int)res + "\n");
        }
        System.out.println(sb.toString());
    }
}
