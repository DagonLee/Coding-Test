package boj.Greedy;

import java.io.*;
import java.util.*;

public class boj14719 {
    /*
     * 빗물을 고이게 하려면 현재 확인하는 높이를 기준으로 왼쪽의 최대 높이, 오른쪽의 최대 높이의 최솟값과 비교하여
     * 현재 시점의 고인 물의 양을 계산한다.
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h, w;
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        int[] heights = new int[w];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++){
            heights[i] = Integer.parseInt(st.nextToken());
        }
        int[] left = new int[w];
        int[] right = new int[w];
        left[0] = heights[0];
        right[w - 1] = heights[w - 1];
        int leftMax = heights[0];
        int rightMax = heights[w - 1];
        for(int i = 1; i < w; i++){
            left[i] = leftMax;
            if(heights[i] > leftMax){
                leftMax = heights[i];
            }
            right[w - 1 - i] = rightMax;
            if(heights[w - 1 - i] > rightMax){
                rightMax = heights[w - 1 - i];
            }
        }

        int ans = 0;
        for(int i = 1; i < w - 1; i++){
            int val = Math.min(left[i], right[i]);
            int cur = heights[i];
            if(val - cur >= 0){
                ans += (val - cur);
            }
        }
        System.out.println(ans);
    }
}
