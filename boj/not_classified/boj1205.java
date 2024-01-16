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
        int dest = -1;
        for(int i = 0; i < nums.size(); i++){
            if(nums.get(i) <= score){
                dest = i;
                while(dest + 1 < nums.size() && nums.get(dest + 1) == score){
                    dest ++;
                }
                if(dest + 1 == p && nums.get(dest) == score){
                    System.out.println(-1);
                    return;
                }
                break;
            }
        }
        if(dest == -1){
            if(nums.size() < p ){
                System.out.println(nums.size() + 1);
            }
            else{
                System.out.println(-1);
            }
        }
        else{
            while(dest - 1 >= 0 && nums.get(dest - 1) == score){
                dest--;
            }
            System.out.println(dest + 1);
        }
    }
}
