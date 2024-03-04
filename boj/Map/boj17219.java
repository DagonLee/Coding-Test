package boj.Map;

import java.io.*;
import java.util.*;
public class boj17219 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> account = new HashMap<>();
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            account.put(st.nextToken(), st.nextToken());
        }
        for(int i = 0; i < m; i++){
            sb.append(account.get(br.readLine()) + "\n");
        }
        System.out.println(sb.toString());
    }
}
