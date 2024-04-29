package boj.Graph;

import java.io.*;
import java.util.*;

public class boj9934 {
    static ArrayList<Integer> nums = new ArrayList<>();
    static double n;
    static ArrayList<Integer>[] ans;
    static void print(int start, int end, int cnt){
        int mid = (start + end) / 2;
        if(cnt == 0){
            return;
        }
        ans[cnt].add(nums.get(mid));
        print(start, mid - 1, cnt - 1);
        print(mid + 1, end, cnt - 1);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Double.parseDouble(br.readLine());
        ans = new ArrayList[(int)n + 1];
        for(int i = 1; i<= n; i++){
            ans[i] = new ArrayList<>();
        }
        int len = (int)Math.pow(2L, n) - 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < len; i++){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        print(0, len  - 1, (int)n);
        for(int i = (int)n; i >= 1; i--){
            for(int num : ans[i]){
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}
