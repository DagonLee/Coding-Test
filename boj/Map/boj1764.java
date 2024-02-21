package boj.Map;

import java.io.*;
import java.util.*;
public class boj1764 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Map <String, Integer> map = new HashMap<>();
        ArrayList<String> lst = new ArrayList<>();
        for(int i = 0; i < n + m; i++){
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
            if(map.get(str) == 2){
                lst.add(str);
            }
        }
        Collections.sort(lst);
        System.out.println(lst.size());
        for(String s : lst){
            System.out.println(s);
        }
    }
}
