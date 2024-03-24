package boj.Implementation;

import java.io.*;
import java.util.*;

public class boj4101 {
    public static void main(String[] arsg) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0){
                break;
            }
            if(a > b){
                sb.append("Yes\n");
            }
            else{
                sb.append("No\n");
            }
        }
        System.out.println(sb.toString());
    }
}
