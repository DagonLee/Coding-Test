package boj.not_classified;

import java.io.*;
import java.util.*;
public class boj1205 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;
        int score;
        int p; // 랭킹 리스트 제한
        
        ArrayList<Integer> nums = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        score = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        if(n == 0){
            System.out.println(1);
            return;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        if(n == p && nums.get(nums.size() - 1) >= score){
            System.out.println(-1);
            return;
        }
        int dest = n + 1;
        for(int i = 0; i < n; i++){
            if(nums.get(i) <= score){
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(dest);
    }
}
