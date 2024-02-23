package boj.math;

import java.io.*;
import java.util.StringTokenizer;

public class boj1027 {
    /*
     * start 240223 14:22
     * 문제
     * n개의 빌딩 높이가 주어진다.
     * 한 빌딩에서 다른 빌딩을 보려면 두 빌딩의 지붕을 잇는 선분이 다른 빌딩을 접하지 않아야한다.
     * 가장 많은 빌딩을 볼 수 있는 빌딩을 구하고, 거기서 보이는 빌딩의 수를 구하라
     * 
     * 해결방법
     * 차례로 주어진다. => 스택의 가능성
     * 입력이 50으로 작다 => 모든 경우를 찾아도 될 듯 하다
     * 
     * 1. 각 빌딩의 좌우를 탐색한다.
     * 2. 좌는 역순으로 오름차순, 우는 순방향 오름차순이 되는 가장 많은 빌딩 수가 정답
     *  
     * 문제를 잘못 이해 => 문제 분류 확인, 기하학
     * 각 건물 간의 각도를 비교하여 탐색
     * 좌 높이 차이 / 거리 차이 로 각도를 계산 (float) 
     * 좌, 우 각각 각도의 최댓값을 갱신하며 이동 만약 각도가 최댓값 작거나 같다면 패스 크다면 갯수를 + 1 하여 탐색
     * 완성 15:44 => fail
     * 각도 계산 시 (double) 괄호 범위를 잘못 입력, 수정 => success, 15:48
     * 
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        //2 6 3 2 6 4 2 5 7 3
        int ans = 0;
        for(int i = 0; i < n; i++){
            int cnt = 0;
            if(i >= 1){
                double value =  nums[i - 1] - nums[i];
                cnt++;
                int left = i - 2;
                while(left >= 0){
                    double degree = (double)(nums[left] - nums[i])/ (i - left);
                    if(degree > value){
                        cnt++;
                        value = degree;
                    }
                    left --;
                }
            }
            if(i < n - 1){
                double value = nums[i + 1] - nums[i];
                cnt++;
                int right = i + 2;

                while (right < n){
                    double degree = (double)(nums[right] - nums[i]) / (right - i);
                    if(degree > value){
                        cnt++;
                        value = degree;
                    }
                    right ++ ;
                }
            }
            ans = Math.max(cnt, ans);
        }
        System.out.println(ans);
    }
}
