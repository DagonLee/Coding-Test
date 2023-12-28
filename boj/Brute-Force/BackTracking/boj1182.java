import java.io.*;
import java.util.*;

public class boj1182{
    static int n;
    static int s;
    static int ans;
    static int[] nums;
    public static void backTrack(int idx, int sum){
        if(idx == n){
            if(s == sum){
                ans ++;
            }
            return;
        }
        backTrack(idx + 1, sum + nums[idx]);
        backTrack(idx + 1, sum);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        backTrack(0, 0);
        if(s == 0){
            ans --;
        }
        System.out.println(ans);
    }
}