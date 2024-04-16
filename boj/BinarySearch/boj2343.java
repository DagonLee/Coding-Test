package boj.BinarySearch;

import java.io.*;
import java.util.*;

public class boj2343 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] times = new int[n];
        int start = 0;
        int end = 0;
        for(int i = 0; i < n; i++){
            times[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, times[i]);
            end += times[i];
        }
        while(start < end){
            int mid = start + (end - start) / 2; // 블루레이의 크기
            int tmp = 0;
            int cnt = 0;
            for(int i = 0; i < n; i++){
                tmp += times[i];
                if(tmp > mid){
                    cnt++;
                    tmp = times[i];
                }
            }
            if(tmp > 0 ){
                cnt++;
            }
            if(cnt > m){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        System.out.println(start);

    }
}
