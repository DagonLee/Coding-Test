package boj.Implementation;

import java.io.*;
import java.util.StringTokenizer;

public class boj14719 {
    /*
     * start 240213 21:56
     * 문제
     * 가로 길이와 세로 길이가 주어진다.
     * 비가오면 고이는 빗물의 총량을 구하라
     * 
     * 해결방법이 안떠올라서 다른 풀이를 탐색
     * 정리
     * 오목한 구조가 되려면 한 지점을 기준으로 양 옆에 해당 지점 보다 큰 높이가 있어야 한다.
     * 그리고 왼쪽, 오른쪽을 기준으로 높이의 최댓값을 찾고 양 높이의 최솟값이 물 높이의 제한이 된다.
     * 
     * 해결방법
     * 1. 1 ~ w - 2 인덱스를 순회한다.
     * 2. 왼쪽으로의 최대높이, 오른쪽으로의 최대 높이를 구하여 두 높이의 최솟 값이 물 높이가 된다.
     * 3. 물 높이가 현재 지점의 높이 보다 큰 경우, 물높이 - 해당 지점 높이를 고이는 물 양에 더해준다.
     * 
     * 저장 데이터
     * 입력
     * int h // 세로
     * int w // 가로
     * int[] height // 높이 배열
     * int collected // 고이는 물 양
     * 
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int collected = 0;
        int[] heights = new int[w];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++){
            heights[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i < w - 1; i++){
            int leftMax = 0;
            int rightMax = 0;
            for(int left = i - 1; left >= 0; left --){
                leftMax = Math.max(leftMax, heights[left]);
            }
            for(int right = i + 1; right < w; right++){
                rightMax = Math.max(rightMax, heights[right]);
            }
            int limit = Math.min(rightMax, leftMax);
            if(heights[i] < limit){
                collected += (limit - heights[i]);
            }
        }
        System.out.println(collected);
    }
}
