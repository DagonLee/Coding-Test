package boj.not_classified;

import java.io.*;
import java.util.*;

public class boj20920 {
    //start 240121 21:07
    //1st try : 240121 21:30 fail, class initialization miss
    //2nd try : 240121 21:36 success,
    static class word implements Comparable<word>{
        String str;
        int length;
        int cnt;
        public word(String str, int length, int cnt){
            this.str = str;
            this.length = length;
            this.cnt = cnt;
        }
        public void cntAdd(){
            cnt++;
        }
        
        @Override
        public int compareTo(word o) {
            if(this.cnt == o.cnt){
                if(this.length == o.length){
                    return str.compareTo(o.str);
                }
                return o.length - this.length;
            }
            return o.cnt - this.cnt;
        }
    }
    public static void main(String[] args) throws Exception{
        int n, m;
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            if(s.length() >= m){
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        ArrayList<word> lst = new ArrayList<>();
        for(String s : map.keySet()){
            lst.add(new word(s, s.length(), map.get(s)));
        }
        Collections.sort(lst);
        for(word w : lst){
            sb.append(w.str+"\n");
        }
        System.out.print(sb.toString());
    }
}
