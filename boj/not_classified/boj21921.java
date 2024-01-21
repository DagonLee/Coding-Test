package boj.not_classified;

import java.io.*;
import java.util.*;

public class boj21921 {
    //start: 240121 21:41
    // 1st try: 240121 21:51 fail => time limit exceeded
    // re-start 11:20 
    // 2nd try: 11:29 success
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, x;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> lst = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            lst.add(Integer.parseInt(st.nextToken()));
        }

        int max_visitors = 0;
        
        int same_cnt = 1;
        for(int i = 0; i < x; i++){
            max_visitors += lst.get(i);
        }

        int visitors = max_visitors;
        for(int i = x; i < n; i++){
            visitors -= lst.get(i - x);
            visitors += lst.get(i);
            if(max_visitors == visitors){
                same_cnt++;
            }
            else if(max_visitors < visitors){
                max_visitors = visitors;
                same_cnt = 1;
            }
        }

        if(max_visitors == 0){
            System.out.println("SAD");
        }
        else{
            System.out.println(max_visitors);
            System.out.println(same_cnt);
        
        }
    }
}
