package boj.TwoPointer;

import java.io.*;
import java.util.*;

public class boj2473 {
    /*
     * 240315 14:53
     * 문제
     * 세 수를 합하여 0에 가장 가까운 경우를 출력하라
     * 수는 -10억 ~ 10억 정수
     * 
     * 해결방법
     * 투 포인터를 통해 해결 
     * 한 수를 고정하고 두 수는 투포인터로 0과 가장 가까운 수를 만들어서 갱신
     * 
     */
    static int first, second, third;
    static long val;
    static long[] nums;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(nums);
        val = Long.MAX_VALUE;
        for(int i = 0; i < n - 2; i++){
            int left = i + 1;
            int right = n - 1;
            while(left < right){
                long tmp = nums[i] + nums[left] + nums[right];
                if(Math.abs(tmp) < val){
                    
                    val = Math.abs(tmp);
                    first = i;
                    second = left;
                    third = right;
                }
                if(tmp == 0){
                    break;
                }
                else if(tmp < 0){
                    left ++;
                }
                else{
                    right--;
                }
            }
        }

        ArrayList<Long> liquids = new ArrayList<>();
        liquids.add(nums[first]);
        liquids.add(nums[second]);
        liquids.add(nums[third]);
        Collections.sort(liquids);
        System.out.println(liquids.get(0) + " " +  liquids.get(1) + " " + liquids.get(2));
    }
}
