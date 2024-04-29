package boj.Sort;

import java.io.*;
import java.util.*;

public class boj11497 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> heights = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int height = Integer.parseInt(st.nextToken());
                heights.add(height);
            }
            Collections.sort(heights);
            ArrayList<Integer> lst = new ArrayList<>();
            int idx = 0;
            while(idx < heights.size()){
                lst.add(heights.get(idx));
                idx += 2;
            }
            if(heights.size() % 2 == 0){
                idx = heights.size() - 1;
                while(idx >= 0){
                    lst.add(heights.get(idx));
                    idx -= 2;
                }
            }
            else{
                idx = heights.size() - 2;
                while(idx >= 0){
                    lst.add(heights.get(idx));
                    idx -= 2;
                }
            }
            
            int dif = 0;
            for(int i = 0; i < heights.size() - 1; i++){
                dif = Math.max(dif, Math.abs(lst.get(i + 1) - lst.get(i)));
            }
 
            dif = Math.max(dif, Math.abs(lst.get(lst.size() - 1) - lst.get(0)));
            sb.append(dif + "\n");
        }
        System.out.println(sb.toString());
    }
}
