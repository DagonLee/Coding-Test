package boj.BinarySearch;

import java.io.*;
import java.util.*;

public class boj7453 {

    static int upperBound(int[]arr, int target){
        int left = 0;
        int right = arr.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] <= target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left - 1;
    }

    static int lowerBound(int[] arr, int target){
        int left = 0;
        int right = arr.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }
        int[] abSum = new int[n * n];
        int[] cdSum = new int[n * n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                abSum[idx] = a[i] + b[j];
                cdSum[idx] = c[i] + d[j];
                idx++;
            }
        }

        Arrays.sort(abSum);
        Arrays.sort(cdSum);

        long ans = 0;
        for(int sum : abSum){
            // int target = - sum;
            ans += (upperBound(cdSum, -sum) - lowerBound(cdSum, -sum) + 1);
        }
        System.out.println(ans);
    }
}