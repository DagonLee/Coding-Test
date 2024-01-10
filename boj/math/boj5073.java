package boj.math;
import java.io.*;
import java.util.StringTokenizer;

public class boj5073 {
    static int decision(int [] nums){
        if(nums[0] == nums[1]){
            if(nums[1] == nums[2]){
                return 0;
            }
            else{
                return 1;
            }
        }
        else{
            if(nums[0] == nums[2] || nums[1] == nums[2])
            {
                return 1;
            }
            else{
                return 2;
            }       
        } 
    }
    
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            int[] nums = new int[3];
            int sum = 0;
            int max_idx = 0;
            int max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 3; i++){
                nums[i] = Integer.parseInt(st.nextToken());
                sum += nums[i];
                if(max < nums[i]){
                    max = nums[i];
                    max_idx = i;
                }
            }
            if(sum == 0){
                break;

            }
            int others = 0;
            for(int i = 0; i < 3; i++){
                if(i != max_idx){
                    others += nums[i];
                }
            }
            int res = decision(nums);
            if(others <= max){
                System.out.println("Invalid");
            }
            else if(res == 0){
                System.out.println("Equilateral");
            }
            else if(res == 1){
                System.out.println("Isosceles");
            }
            else if(res == 2){
                System.out.println("Scalene");
            }
        }
    }
}
