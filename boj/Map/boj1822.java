package boj.Map;

import java.io.*;
import java.util.*;
public class boj1822 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a, b;
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        Map<Integer, Boolean> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < a; i++){
            map.put(Integer.parseInt(st.nextToken()), false);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < b; i++){
            int val = Integer.parseInt(st.nextToken());
            if(map.containsKey(val)){
                map.put(val, true);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == false){
                ans.add(key);
            }
        }

        Collections.sort(ans);
        if(ans.size() == 0){
            System.out.println(0);
        }else{
            System.out.println(ans.size());
            for(int val : ans){
                System.out.print(val + " ");
            }
        }
    }
}
