package boj.Map;

import java.io.*;
import java.util.*;


public class boj2022 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<String> in = new ArrayDeque<>();
        Queue<String> out = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            String num = br.readLine();
            in.add(num);
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            String num = br.readLine();
            out.add(num);
        }
        while(!out.isEmpty()){
            String car = out.poll();
            if(!in.peek().equals(car)){
                cnt++;
                in.remove(car);
            }else{
                in.poll();
            }
        }
        System.out.println(cnt);
    }
}
