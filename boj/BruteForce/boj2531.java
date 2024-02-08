package boj.BruteForce;


import java.io.*;
import java.util.StringTokenizer;

public class boj2531 {
    
    static int n; //접시 수
    static int d; // 초밥 가짓수
    static int k; // 연속 먹는 접시 수
    static int c; // 쿠폰 번호
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int ans = 0;
        int[] rail = new int[n];
        for(int i = 0; i < n; i++){
            rail[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < n; i++){
            int[] check = new int[d + 1];
            int cnt = 0;
            boolean bonus_included = false;
            for(int j = i; j < i + k; j++){
                check[rail[j % n]] ++;
                if(rail[j % n] == c){
                    bonus_included = true;
                }
            }
            if(!bonus_included){
                cnt++;
            }
            for(int j = 1; j <= d; j++){
                if(check[j] > 0){
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }

}
