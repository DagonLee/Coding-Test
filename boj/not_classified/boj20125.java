package boj.not_classified;

import java.io.*;
import java.util.*;
public class boj20125 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < n; j++){
                if(line.charAt(j) == '_'){
                    grid[i][j] = 0;
                }
                else{
                    grid[i][j] = 1;
                }
                
            }
            
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i >= 1 && i < n - 1 && j >= 1 && j < n - 1){
                    if(grid[i - 1][j] == 1 && grid[i + 1][j] == 1 && grid[i][j - 1] == 1 && grid[i][j + 1] == 1){
                        // 왼팔
                        int leftArm = 0;
                        int leftArmIdx = j - 1;
                        while(leftArmIdx >= 0 && grid[i][leftArmIdx] == 1){
                            leftArm++;
                            leftArmIdx--;
                        }
                        // 오른팔
                        int rightArm = 0;
                        int rightArmIdx = j + 1;
                        while(rightArmIdx < n && grid[i][rightArmIdx] == 1){
                            rightArm++;
                            rightArmIdx++;
                        }
                        // 허리 끝 찾기
                        int wristEnd = i;
                        while(grid[wristEnd + 1][j] == 1){
                            wristEnd ++;
                        }
                        
                        // 왼다리
                        int leftLeg = 0;
                        int leftLegIdx = wristEnd + 1;
                        while(leftLegIdx < n && grid[leftLegIdx][j - 1] == 1){
                            leftLegIdx++;
                            leftLeg++;
                        }
                        // 오른 다리
                        int rightLeg = 0;
                        int rightLegIdx = wristEnd + 1;
                        while(rightLegIdx < n && grid[rightLegIdx][j + 1] == 1){
                            rightLegIdx++;
                            rightLeg++;
                        }
                        System.out.println((i + 1)  + " " + (j + 1));
                        System.out.println(leftArm + " " + rightArm + " " + (wristEnd - i) + " " + leftLeg + " " + rightLeg);
                    }
                }
            }
        }
        

    }

}
