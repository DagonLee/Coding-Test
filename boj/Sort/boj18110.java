package boj.Sort;
import java.io.*;
import java.util.*;
public class boj18110 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = (int)Math.round((double)(n * 15) / 100);
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        int sum = 0;
        for(int i = cnt;  i < n - cnt; i++){
            sum += nums[i];
        }
        int avg = (int) Math.round((double)sum / (n - (2 * cnt)));
        System.out.println(avg);
    }
}
