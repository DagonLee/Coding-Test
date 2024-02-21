package boj.Map;

import java.io.*;
import java.util.*;
public class boj7662 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++){
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                char com = st.nextToken().charAt(0);
                int val = Integer.parseInt(st.nextToken());
                if(com == 'I'){
                    map.put(val, map.getOrDefault(val, 0) + 1);
                }
                else if(com == 'D'){
                    if(map.isEmpty()){
                        continue;
                    }
                    if(val == -1){
                        int del = map.firstKey();
                        int cnt = map.get(del);
                        if(cnt <= 1){
                            map.remove(del);
                        }
                        else{
                            map.put(del, cnt - 1);
                        }
                    }
                    else if(val == 1){
                        int del = map.lastKey();
                        int cnt = map.get(del);
                        if(cnt <= 1){
                            map.remove(del);
                        }
                        else{
                            map.put(del, cnt - 1);
                        }
                    }
                }
            }
            
            if(map.size() == 0){
                sb.append("EMPTY\n");
            }
            else{
                sb.append(map.lastKey() + " " + map.firstKey()+ "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
