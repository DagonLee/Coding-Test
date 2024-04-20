package boj.math;

import java.io.*;
import java.util.*;

public class boj1850 {
    static Long gcd(Long a, Long b){
        Long tmp, n;
        if(a < b){
            tmp = a;
            a = b;
            b = tmp;
        }

        while(b != 0){
            n = a % b;
            a = b;
            b = n;
        }
        return a;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Long a = Long.parseLong(st.nextToken());
        Long b = Long.parseLong(st.nextToken());
        Long times = gcd(a, b);

        for(int i = 0; i < times; i++){
            sb.append("1");
        }
        System.out.println(sb.toString());
    }
}
