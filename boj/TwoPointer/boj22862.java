package boj.TwoPointer;
import java.io.*;
import java.util.*;
public class boj22862 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[s];
        for(int i = 0; i < s; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int left = 0;
        int right = 0;
        int cnt = 0;
        while(true){
            if(cnt > k){
                if(nums[left] % 2 == 1){
                    cnt --;
                }
                left++;
            }
            else if(right == s){
                break;
            }
            else{
                if(nums[right] % 2 == 1){
                    cnt++;
                }
                right++;
            }
            if(cnt <= k){
                ans = Math.max(ans, right - left - cnt);
            }
        }
        System.out.println(ans);
    }
}
