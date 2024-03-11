package boj.BinarySearch;
import java.io.*;
import java.util.*;
public class boj16401 {
    /*
     * 문제
     * m명의 조카 , n 개의 과자가 있을때 조카에게 최대한 긴 과자를 줄때
     * 가장 작은 과자의 길이를 반환하라
     * 
     * 해결방법
     * 1. 내림 차순으로 막대과자를 정렬
     * 2. M 번째 과자의 길이를 출력
     * 
     * 여러 조각으로 쪼개진다는 부분을 놓침
     * 
     * 이분 탐색으로 최댓 값을 찾도록 진행
     * 
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m, n;
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int start = 1;
        int end = -1;
        int sum = 0;
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            int val = Integer.parseInt(st.nextToken());
            sum += val;
            if(val > end){
                end = val;
            }
            nums[i] = val;
        }
        if(sum < m){
            System.out.println(0);
            return;
        }
        while(start <= end){
            int mid = (start + end) / 2;
            int cnt = 0;
            for(int i = 0; i < n; i++){
                cnt += (nums[i] / mid);
            }
            if(cnt >= m){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}
