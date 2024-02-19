package boj.BruteForce;
import java.io.*;
import java.util.*;
public class boj7490_1 {
    static int N;
    static ArrayList<String> ans;
    static String op[] = {"+", "-", " "};
    private static void dfs(int num, String s){
        if(num == N){
            String express = s.replaceAll(" ", "");
            if(cal(express)){
                ans.add(s);
            }
            return;
        }
        for(int i = 0; i < 3; i++){
            dfs(num + 1, s + op[i] + Integer.toString(num + 1));
        }
    }
    private static boolean cal(String express){
        StringTokenizer st = new StringTokenizer(express, "-+", true);
        int sum = Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()){
            String s = st.nextToken();
            if(s.equals("+")){
                sum += Integer.parseInt(st.nextToken());
            }
            else{
                sum -= Integer.parseInt(st.nextToken());
            }
        }
        if(sum == 0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            ans = new ArrayList<>();
            dfs(1, "1");
            Collections.sort(ans);
            for(String s : ans){
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
