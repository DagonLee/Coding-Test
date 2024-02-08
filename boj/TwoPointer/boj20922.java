package boj.TwoPointer;

import java.io.*;
import java.util.*;

public class boj20922 {
    /*
     * start 240208 18:41
     * 문제
     * 같은 원소가 k개 이하로 들어있는 최장 연속 부분 수열의 길이를 구하라
     * 길이 : n, 중복제한: k
     * 문제 풀이
     * 1. 해시맵을 통해 원소의 등장 횟수를 저장
     * 2. k번 이상 나오는 경우는 길이를 최대 길이와 비교하여 저장하고 해시맵을 초기화하여 다시 시작
     * 2번 시도 => fail
     * 19:00 => 문제 분류 힌트 확인
     * 19:20 ~ 19:53 => 문제 풀이 완료
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> cnt = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        int left = 0;
        int ans = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            int val = Integer.parseInt(st.nextToken());
            nums[i] = val;
        }
        for(int right = 0; right < n; right++)
        {
            int val = nums[right];
            if(cnt.containsKey(val)){
                if(cnt.get(val) < k){
                    cnt.put(val, cnt.get(val) + 1);
                }
                else{
                    /*
                     * 9 2 3 2 5 5 6 4 4 5 7
                     */
                    while(left < right){
                        if(nums[left] == val){
                            left++;
                            break;
                        }
                        cnt.put(nums[left], cnt.get(nums[left]) - 1);
                        left++;
                    }
                    max = Math.max(ans, max);
                    ans = (right - left) + 1;
                    continue;                    
                }
            }
            else{
                cnt.put(val, 1);
            }
            ans++;
        }
        max = Math.max((n - left), max);
        System.out.println(max);
    }
}
